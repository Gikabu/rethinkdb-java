package com.rethinkdb.net;

import com.rethinkdb.gen.exc.ReqlDriverError;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Crypto {
    private static final String DEFAULT_SSL_PROTOCOL = "TLSv1.2";
    private static final String HMAC_SHA_256 = "HmacSHA256";
    private static final String PBKDF2_ALGORITHM = "PBKDF2withHmacSHA256";

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Map<PasswordLookup, byte[]> pbkdf2Cache = new ConcurrentHashMap<>();
    private static final int NONCE_BYTES = 18;

    private static class PasswordLookup {
        final byte[] password;
        final byte[] salt;
        final int iterations;

        PasswordLookup(byte[] password, byte[] salt, int iterations) {
            this.password = password;
            this.salt = salt;
            this.iterations = iterations;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PasswordLookup that = (PasswordLookup) o;

            if (iterations != that.iterations) return false;
            if (!Arrays.equals(password, that.password)) return false;
            return Arrays.equals(salt, that.salt);

        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(password);
            result = 31 * result + Arrays.hashCode(salt);
            result = 31 * result + iterations;
            return result;
        }
    }

    private static byte[] cacheLookup(byte[] password, byte[] salt, int iterations) {
        return pbkdf2Cache.get(new PasswordLookup(password, salt, iterations));
    }

    private static void setCache(byte[] password, byte[] salt, int iterations, byte[] result) {
        pbkdf2Cache.put(new PasswordLookup(password, salt, iterations), result);
    }

    static byte[] sha256(byte[] clientKey) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(clientKey);
        } catch (NoSuchAlgorithmException e) {
            throw new ReqlDriverError(e);
        }
    }

    static byte[] hmac(byte[] key, String string) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA_256);
            SecretKeySpec secretKey = new SecretKeySpec(key, HMAC_SHA_256);
            mac.init(secretKey);
            return mac.doFinal(string.getBytes(StandardCharsets.UTF_8));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new ReqlDriverError(e);
        }
    }

    static byte[] pbkdf2(byte[] password, byte[] salt, Integer iterationCount) {
        final byte[] cachedValue = cacheLookup(password, salt, iterationCount);
        if (cachedValue != null) {
            return cachedValue;
        }
        
        PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());
        gen.init(password, salt, iterationCount);
        final byte[] calculatedValue = ((KeyParameter) gen.generateDerivedParameters(256)).getKey();
        setCache(password, salt, iterationCount, calculatedValue);
        return calculatedValue;
//         final PBEKeySpec spec = new PBEKeySpec(new String(password, StandardCharsets.UTF_8).toCharArray(),
//             salt, iterationCount, 128);
        
//         final SecretKeyFactory skf;
//         try {
//             PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());
//             gen.init(password, salt, iterationCount);
//             final byte[] calculatedValue = ((KeyParameter) gen.generateDerivedParameters(256)).getKey();
//             setCache(password, salt, iterationCount, calculatedValue);
//             return calculatedValue;
            
//         } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//             throw new ReqlDriverError(e);
//         }
    }

    static String makeNonce() {
        byte[] rawNonce = new byte[NONCE_BYTES];
        secureRandom.nextBytes(rawNonce);
        return toBase64(rawNonce);
    }

    static byte[] xor(byte[] a, byte[] b) {
        if (a.length != b.length) {
            throw new ReqlDriverError("arrays must be the same length");
        }
        byte[] result = new byte[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }

    static String toBase64(byte[] bytes) {
        return new String(encoder.encode(bytes), StandardCharsets.UTF_8);
    }

    static byte[] fromBase64(String string) {
        return decoder.decode(string);
    }

    static SSLContext readCertFile(@Nullable InputStream certFile) {
        try {
            final CertificateFactory cf = CertificateFactory.getInstance("X.509");
            final X509Certificate caCert = (X509Certificate) cf.generateCertificate(certFile);

            final TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(null); // You don't need the KeyStore instance to come from a file.
            ks.setCertificateEntry("caCert", caCert);
            tmf.init(ks);

            final SSLContext ssc = SSLContext.getInstance(DEFAULT_SSL_PROTOCOL);
            ssc.init(null, tmf.getTrustManagers(), null);
            return ssc;
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new ReqlDriverError(e);
        }
    }
}
