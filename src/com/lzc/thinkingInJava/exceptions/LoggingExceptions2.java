package com.lzc.thinkingInJava.exceptions;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;



public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");
    public static void logException(Exception e){
        StringWriter s = new StringWriter();
        e.printStackTrace(new PrintWriter(s));
        logger.severe(s.toString());
    }
    public static void main(String[] args){
        try{
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
