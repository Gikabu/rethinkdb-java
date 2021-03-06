// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../templates/Test.java
package com.rethinkdb.gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.ast.*;
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

public class DatumBool {
    // Tests of conversion to and from the RQL bool type
    Logger logger = LoggerFactory.getLogger(DatumBool.class);
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

        {
            // datum/bool.yaml line #3
            /* true */
            Boolean expected_ = true;
            /* r.expr(True) */
            logger.info("About to run line #3: r.expr(true)");
            Object obtained = runOrCatch(r.expr(true),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #3");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #3:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #10
            /* false */
            Boolean expected_ = false;
            /* r.expr(False) */
            logger.info("About to run line #10: r.expr(false)");
            Object obtained = runOrCatch(r.expr(false),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #10");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #10:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #17
            /* 'BOOL' */
            String expected_ = "BOOL";
            /* r.expr(False).type_of() */
            logger.info("About to run line #17: r.expr(false).typeOf()");
            Object obtained = runOrCatch(r.expr(false).typeOf(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #17");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #17:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #21
            /* 'true' */
            String expected_ = "true";
            /* r.expr(True).coerce_to('string') */
            logger.info("About to run line #21: r.expr(true).coerceTo('string')");
            Object obtained = runOrCatch(r.expr(true).coerceTo("string"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #21");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #21:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #24
            /* True */
            Boolean expected_ = true;
            /* r.expr(True).coerce_to('bool') */
            logger.info("About to run line #24: r.expr(true).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr(true).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #24");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #24:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #27
            /* False */
            Boolean expected_ = false;
            /* r.expr(False).coerce_to('bool') */
            logger.info("About to run line #27: r.expr(false).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr(false).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #27");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #27:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #30
            /* False */
            Boolean expected_ = false;
            /* r.expr(null).coerce_to('bool') */
            logger.info("About to run line #30: r.expr((ReqlExpr) null).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr((ReqlExpr) null).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #30");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #30:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #33
            /* True */
            Boolean expected_ = true;
            /* r.expr(0).coerce_to('bool') */
            logger.info("About to run line #33: r.expr(0L).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr(0L).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #33");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #33:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #36
            /* True */
            Boolean expected_ = true;
            /* r.expr('false').coerce_to('bool') */
            logger.info("About to run line #36: r.expr('false').coerceTo('bool')");
            Object obtained = runOrCatch(r.expr("false").coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #36");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #36:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #39
            /* True */
            Boolean expected_ = true;
            /* r.expr('foo').coerce_to('bool') */
            logger.info("About to run line #39: r.expr('foo').coerceTo('bool')");
            Object obtained = runOrCatch(r.expr("foo").coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #39");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #39:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #42
            /* True */
            Boolean expected_ = true;
            /* r.expr([]).coerce_to('bool') */
            logger.info("About to run line #42: r.expr(r.array()).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr(r.array()).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #42");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #42:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // datum/bool.yaml line #45
            /* True */
            Boolean expected_ = true;
            /* r.expr({}).coerce_to('bool') */
            logger.info("About to run line #45: r.expr(r.hashMap()).coerceTo('bool')");
            Object obtained = runOrCatch(r.expr(r.hashMap()).coerceTo("bool"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #45");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #45:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
