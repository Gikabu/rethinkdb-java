// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../templates/Test.java
package com.rethinkdb.gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static com.rethinkdb.TestingCommon.*;
import com.rethinkdb.TestingFramework;

public class TimesShim {
    // Test the native shims.
    Logger logger = LoggerFactory.getLogger(TimesShim.class);
    public static final RethinkDB r = RethinkDB.r;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up.");
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        logger.info("Tearing down.");
        r.db("rethinkdb").table("_debug_scratch").delete().run(conn);
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.dbDrop("test").run(conn);
        conn.close(false);
    }

    // Matches Python's str() function, which we use.
    // TODO: We might want to handle this in a visit_Call in convert_tests.py instead.
    private static String str(long i) {
        return String.valueOf(i);
    }

    // A hack to concatenate two Lists -- see is_array_add in convert_tests.py.
    private static List concatList(List x, List y) {
        List ret = new ArrayList<Long>(x);
        ret.addAll(y);
        return ret;
    }

    // Autogenerated tests below

    @Test(timeout=120000)
    public void test() throws Exception {

        // times/shim.yaml line #4
        // t = 1375147296.68
        logger.info("Possibly executing: Double t = (Double) (1375147296.68);");
        Double t = (Double) (1375147296.68);

        {
            // times/shim.yaml line #8
            /* ("2013-07-29T18:21:36.680-07:00") */
            String expected_ = "2013-07-29T18:21:36.680-07:00";
            /* r.expr(datetime.fromtimestamp(t, PacificTimeZone())).to_iso8601() */
            logger.info("About to run line #8: r.expr(datetime.fromtimestamp(t, PacificTimeZone())).toIso8601()");
            Object obtained = runOrCatch(r.expr(datetime.fromtimestamp(t, PacificTimeZone())).toIso8601(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #8");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #8:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/shim.yaml line #12
            /* ("2013-07-30T01:21:36.680+00:00") */
            String expected_ = "2013-07-30T01:21:36.680+00:00";
            /* r.expr(datetime.fromtimestamp(t, UTCTimeZone())).to_iso8601() */
            logger.info("About to run line #12: r.expr(datetime.fromtimestamp(t, UTCTimeZone())).toIso8601()");
            Object obtained = runOrCatch(r.expr(datetime.fromtimestamp(t, UTCTimeZone())).toIso8601(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #12");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #12:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/shim.yaml line #16
            /* (1375147296.68) */
            Double expected_ = 1375147296.68;
            /* r.expr(datetime.fromtimestamp(t, PacificTimeZone())).to_epoch_time() */
            logger.info("About to run line #16: r.expr(datetime.fromtimestamp(t, PacificTimeZone())).toEpochTime()");
            Object obtained = runOrCatch(r.expr(datetime.fromtimestamp(t, PacificTimeZone())).toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #16");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/shim.yaml line #20
            /* (1375147296.68) */
            Double expected_ = 1375147296.68;
            /* r.expr(datetime.fromtimestamp(t, UTCTimeZone())).to_epoch_time() */
            logger.info("About to run line #20: r.expr(datetime.fromtimestamp(t, UTCTimeZone())).toEpochTime()");
            Object obtained = runOrCatch(r.expr(datetime.fromtimestamp(t, UTCTimeZone())).toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #20");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #20:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
