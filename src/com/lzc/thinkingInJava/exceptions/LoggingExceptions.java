package com.lzc.thinkingInJava.exceptions;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggerException extends Exception{
    private static Logger logger = Logger.getLogger("LoggerException");
    public LoggerException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingExceptions {
    public static void main(String[] args){
        try{
            throw new LoggerException();
        } catch (LoggerException e) {
            System.err.println("Caught " + e);
        }
        try{
            throw new LoggerException();
        } catch (LoggerException e) {
            System.err.println("Caught " + e);
        }
    }
}
