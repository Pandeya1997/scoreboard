package org.example.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerHelper {
    private static Logger logger = LogManager.getLogger(org.example.utils.LoggerHelper.class);

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}


