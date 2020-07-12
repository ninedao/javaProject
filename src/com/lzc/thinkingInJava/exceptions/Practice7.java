package com.lzc.thinkingInJava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Practice7 {
    private static Logger logger = Logger.getLogger("Practice7");
    public void d(){
        System.out.println(1);
    }
    static void logException(Exception e) { // Exception e argument
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args){
        String[] array = new String[10];
        try {
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e){
            logException(e);
        }
    }
}
