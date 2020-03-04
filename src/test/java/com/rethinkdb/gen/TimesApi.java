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

public class TimesApi {
    // date/time api (#977)
    Logger logger = LoggerFactory.getLogger(TimesApi.class);
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

        // times/api.yaml line #6
        // rt1 = 1375147296.6812
        logger.info("Possibly executing: Double rt1 = (Double) (1375147296.6812);");
        Double rt1 = (Double) (1375147296.6812);

        // times/api.yaml line #7
        // t1 = r.epoch_time(rt1)
        logger.info("Possibly executing: EpochTime t1 = (EpochTime) (r.epochTime(rt1));");
        EpochTime t1 = (EpochTime) (r.epochTime(rt1));

        // times/api.yaml line #8
        // t2 = r.epoch_time(rt1 + 1000)
        logger.info("Possibly executing: EpochTime t2 = (EpochTime) (r.epochTime(r.add(rt1, 1000L)));");
        EpochTime t2 = (EpochTime) (r.epochTime(r.add(rt1, 1000L)));

        {
            // times/api.yaml line #11
            /* (1375148296.681) */
            Double expected_ = 1375148296.681;
            /* (t1 + 1000).to_epoch_time() */
            logger.info("About to run line #11: r.add(t1, 1000L).toEpochTime()");
            Object obtained = runOrCatch(r.add(t1, 1000L).toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #11");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #11:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #14
            /* (1375146296.681) */
            Double expected_ = 1375146296.681;
            /* (t1 - 1000).to_epoch_time() */
            logger.info("About to run line #14: r.sub(t1, 1000L).toEpochTime()");
            Object obtained = runOrCatch(r.sub(t1, 1000L).toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #14");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #14:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #17
            /* 1000 */
            Long expected_ = 1000L;
            /* (t1 - (t1 - 1000)) */
            logger.info("About to run line #17: r.sub(t1, r.sub(t1, 1000L))");
            Object obtained = runOrCatch(r.sub(t1, r.sub(t1, 1000L)),
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
            // times/api.yaml line #22
            /* false */
            Boolean expected_ = false;
            /* (t1 < t1) */
            logger.info("About to run line #22: r.lt(t1, t1)");
            Object obtained = runOrCatch(r.lt(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #22");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #22:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #25
            /* true */
            Boolean expected_ = true;
            /* (t1 <= t1) */
            logger.info("About to run line #25: r.le(t1, t1)");
            Object obtained = runOrCatch(r.le(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #25");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #25:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #29
            /* true */
            Boolean expected_ = true;
            /* (t1 == t1) */
            logger.info("About to run line #29: r.eq(t1, t1)");
            Object obtained = runOrCatch(r.eq(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #29");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #29:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #32
            /* false */
            Boolean expected_ = false;
            /* (t1 != t1) */
            logger.info("About to run line #32: r.ne(t1, t1)");
            Object obtained = runOrCatch(r.ne(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #32");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #32:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #34
            /* true */
            Boolean expected_ = true;
            /* (t1 >= t1) */
            logger.info("About to run line #34: r.ge(t1, t1)");
            Object obtained = runOrCatch(r.ge(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #34");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #34:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #37
            /* false */
            Boolean expected_ = false;
            /* (t1 > t1) */
            logger.info("About to run line #37: r.gt(t1, t1)");
            Object obtained = runOrCatch(r.gt(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #37");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #37:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #40
            /* true */
            Boolean expected_ = true;
            /* (t1 < t2) */
            logger.info("About to run line #40: r.lt(t1, t2)");
            Object obtained = runOrCatch(r.lt(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #40");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #40:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #43
            /* true */
            Boolean expected_ = true;
            /* (t1 <= t2) */
            logger.info("About to run line #43: r.le(t1, t2)");
            Object obtained = runOrCatch(r.le(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #43");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #43:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #47
            /* false */
            Boolean expected_ = false;
            /* (t1 == t2) */
            logger.info("About to run line #47: r.eq(t1, t2)");
            Object obtained = runOrCatch(r.eq(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #47");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #47:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #50
            /* true */
            Boolean expected_ = true;
            /* (t1 != t2) */
            logger.info("About to run line #50: r.ne(t1, t2)");
            Object obtained = runOrCatch(r.ne(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #50");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #50:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #52
            /* false */
            Boolean expected_ = false;
            /* (t1 >= t2) */
            logger.info("About to run line #52: r.ge(t1, t2)");
            Object obtained = runOrCatch(r.ge(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #52");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #52:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #55
            /* false */
            Boolean expected_ = false;
            /* (t1 > t2) */
            logger.info("About to run line #55: r.gt(t1, t2)");
            Object obtained = runOrCatch(r.gt(t1, t2),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #55");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #55:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #60
            /* true */
            Boolean expected_ = true;
            /* t1.during(t1, t1 + 1000) */
            logger.info("About to run line #60: t1.during(t1, r.add(t1, 1000L))");
            Object obtained = runOrCatch(t1.during(t1, r.add(t1, 1000L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #60");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #60:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #64
            /* false */
            Boolean expected_ = false;
            /* t1.during(t1, t1 + 1000, left_bound='open') */
            logger.info("About to run line #64: t1.during(t1, r.add(t1, 1000L)).optArg('left_bound', 'open')");
            Object obtained = runOrCatch(t1.during(t1, r.add(t1, 1000L)).optArg("left_bound", "open"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #64");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #64:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #67
            /* false */
            Boolean expected_ = false;
            /* t1.during(t1, t1) */
            logger.info("About to run line #67: t1.during(t1, t1)");
            Object obtained = runOrCatch(t1.during(t1, t1),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #67");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #67:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #70
            /* true */
            Boolean expected_ = true;
            /* t1.during(t1, t1, right_bound='closed') */
            logger.info("About to run line #70: t1.during(t1, t1).optArg('right_bound', 'closed')");
            Object obtained = runOrCatch(t1.during(t1, t1).optArg("right_bound", "closed"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #70");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #70:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #77
            /* 1375142400 */
            Long expected_ = 1375142400L;
            /* t1.date().to_epoch_time() */
            logger.info("About to run line #77: t1.date().toEpochTime()");
            Object obtained = runOrCatch(t1.date().toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #77");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #77:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #79
            /* (4896.681) */
            Double expected_ = 4896.681;
            /* t1.time_of_day() */
            logger.info("About to run line #79: t1.timeOfDay()");
            Object obtained = runOrCatch(t1.timeOfDay(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #79");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #79:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #81
            /* 2013 */
            Long expected_ = 2013L;
            /* t1.year() */
            logger.info("About to run line #81: t1.year()");
            Object obtained = runOrCatch(t1.year(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #81");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #81:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #83
            /* 7 */
            Long expected_ = 7L;
            /* t1.month() */
            logger.info("About to run line #83: t1.month()");
            Object obtained = runOrCatch(t1.month(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #83");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #83:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #85
            /* 30 */
            Long expected_ = 30L;
            /* t1.day() */
            logger.info("About to run line #85: t1.day()");
            Object obtained = runOrCatch(t1.day(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #85");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #85:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #87
            /* 2 */
            Long expected_ = 2L;
            /* t1.day_of_week() */
            logger.info("About to run line #87: t1.dayOfWeek()");
            Object obtained = runOrCatch(t1.dayOfWeek(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #87");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #87:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #89
            /* 211 */
            Long expected_ = 211L;
            /* t1.day_of_year() */
            logger.info("About to run line #89: t1.dayOfYear()");
            Object obtained = runOrCatch(t1.dayOfYear(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #89");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #89:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #91
            /* 1 */
            Long expected_ = 1L;
            /* t1.hours() */
            logger.info("About to run line #91: t1.hours()");
            Object obtained = runOrCatch(t1.hours(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #91");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #91:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #93
            /* 21 */
            Long expected_ = 21L;
            /* t1.minutes() */
            logger.info("About to run line #93: t1.minutes()");
            Object obtained = runOrCatch(t1.minutes(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #93");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #93:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #95
            /* 36.681 */
            Double expected_ = 36.681;
            /* t1.seconds() */
            logger.info("About to run line #95: t1.seconds()");
            Object obtained = runOrCatch(t1.seconds(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #95");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #95:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #99
            /* (1375165800.1) */
            Double expected_ = 1375165800.1;
            /* r.time(2013, r.july, 29, 23, 30, 0.1, "-07:00").to_epoch_time() */
            logger.info("About to run line #99: r.time(2013L, r.july(), 29L, 23L, 30L, 0.1, '-07:00').toEpochTime()");
            Object obtained = runOrCatch(r.time(2013L, r.july(), 29L, 23L, 30L, 0.1, "-07:00").toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
            logger.info("Finished running line #99");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #99:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #101
            /* ("-07:00") */
            String expected_ = "-07:00";
            /* r.time(2013, r.july, 29, 23, 30, 0.1, "-07:00").timezone() */
            logger.info("About to run line #101: r.time(2013L, r.july(), 29L, 23L, 30L, 0.1, '-07:00').timezone()");
            Object obtained = runOrCatch(r.time(2013L, r.july(), 29L, 23L, 30L, 0.1, "-07:00").timezone(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #101");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #101:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #109
            /* err("ReqlQueryLogicError", "Expected type STRING but found NUMBER.", []) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type STRING but found NUMBER.", r.array());
            /* r.time(2013, r.july, 29, 23).to_epoch_time() */
            logger.info("About to run line #109: r.time(2013L, r.july(), 29L, 23L).toEpochTime()");
            Object obtained = runOrCatch(r.time(2013L, r.july(), 29L, 23L).toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #109");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #109:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #111
            /* 1375081200 */
            Long expected_ = 1375081200L;
            /* r.time(2013, r.july, 29, "-07:00").to_epoch_time() */
            logger.info("About to run line #111: r.time(2013L, r.july(), 29L, '-07:00').toEpochTime()");
            Object obtained = runOrCatch(r.time(2013L, r.july(), 29L, "-07:00").toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #111");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #111:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #113
            /* ("-07:00") */
            String expected_ = "-07:00";
            /* r.time(2013, r.july, 29, "-07:00").timezone() */
            logger.info("About to run line #113: r.time(2013L, r.july(), 29L, '-07:00').timezone()");
            Object obtained = runOrCatch(r.time(2013L, r.july(), 29L, "-07:00").timezone(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #113");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #113:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #119
            /* 1375242965 */
            Long expected_ = 1375242965L;
            /* r.iso8601("2013-07-30T20:56:05-07:00").to_epoch_time() */
            logger.info("About to run line #119: r.iso8601('2013-07-30T20:56:05-07:00').toEpochTime()");
            Object obtained = runOrCatch(r.iso8601("2013-07-30T20:56:05-07:00").toEpochTime(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #119");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #119:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #122
            /* ("2013-07-30T20:56:05-07:00") */
            String expected_ = "2013-07-30T20:56:05-07:00";
            /* r.epoch_time(1375242965).in_timezone("-07:00").to_iso8601() */
            logger.info("About to run line #122: r.epochTime(1375242965L).inTimezone('-07:00').toIso8601()");
            Object obtained = runOrCatch(r.epochTime(1375242965L).inTimezone("-07:00").toIso8601(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #122");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #122:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #125
            /* ("PTYPE<TIME>") */
            String expected_ = "PTYPE<TIME>";
            /* r.now().type_of() */
            logger.info("About to run line #125: r.now().typeOf()");
            Object obtained = runOrCatch(r.now().typeOf(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #125");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #125:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #127
            /* 0 */
            Long expected_ = 0L;
            /* (r.now() - r.now()) */
            logger.info("About to run line #127: r.now().sub(r.now())");
            Object obtained = runOrCatch(r.now().sub(r.now()),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #127");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #127:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #132
            /* err("ReqlQueryLogicError", "ISO 8601 string has no time zone, and no default time zone was provided.", []) */
            Err expected_ = err("ReqlQueryLogicError", "ISO 8601 string has no time zone, and no default time zone was provided.", r.array());
            /* r.iso8601("2013-07-30T20:56:05").to_iso8601() */
            logger.info("About to run line #132: r.iso8601('2013-07-30T20:56:05').toIso8601()");
            Object obtained = runOrCatch(r.iso8601("2013-07-30T20:56:05").toIso8601(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #132");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #132:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #136
            /* ("2013-07-30T20:56:05-07:00") */
            String expected_ = "2013-07-30T20:56:05-07:00";
            /* r.iso8601("2013-07-30T20:56:05", default_timezone='-07').to_iso8601() */
            logger.info("About to run line #136: r.iso8601('2013-07-30T20:56:05').optArg('default_timezone', '-07').toIso8601()");
            Object obtained = runOrCatch(r.iso8601("2013-07-30T20:56:05").optArg("default_timezone", "-07").toIso8601(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #136");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #136:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #140
            /* ([1, 2, 3, 4, 5, 6, 7]) */
            List expected_ = r.array(1L, 2L, 3L, 4L, 5L, 6L, 7L);
            /* r.expr([r.monday, r.tuesday, r.wednesday, r.thursday, r.friday, r.saturday, r.sunday]) */
            logger.info("About to run line #140: r.expr(r.array(r.monday(), r.tuesday(), r.wednesday(), r.thursday(), r.friday(), r.saturday(), r.sunday()))");
            Object obtained = runOrCatch(r.expr(r.array(r.monday(), r.tuesday(), r.wednesday(), r.thursday(), r.friday(), r.saturday(), r.sunday())),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #140");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #140:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // times/api.yaml line #142
            /* ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]) */
            List expected_ = r.array(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);
            /* r.expr([r.january, r.february, r.march, r.april, r.may, r.june,
r.july, r.august, r.september, r.october, r.november, r.december]) */
            logger.info("About to run line #142: r.expr(r.array(r.january(), r.february(), r.march(), r.april(), r.may(), r.june(), r.july(), r.august(), r.september(), r.october(), r.november(), r.december()))");
            Object obtained = runOrCatch(r.expr(r.array(r.january(), r.february(), r.march(), r.april(), r.may(), r.june(), r.july(), r.august(), r.september(), r.october(), r.november(), r.december())),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #142");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #142:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
