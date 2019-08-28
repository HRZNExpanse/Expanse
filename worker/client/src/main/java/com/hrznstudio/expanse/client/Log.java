package com.hrznstudio.expanse.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    public static Logger LOG = LogManager.getFormatterLogger("");

    public static void info(String s) {
        LOG.info("[Expanse] " + s);
    }

    public static void info(String s, Object... objs) {
        LOG.info("[Expanse] " + s, objs);
    }

    public static void error(String s) {
        LOG.error("[Expanse] " + s);
    }

    public static void error(String s, Throwable e) {
        LOG.error("[Expanse] " + s, e);
    }

    public static void debug(String s) {
        LOG.info("[ExpanseDebug] " + s);
    }
}