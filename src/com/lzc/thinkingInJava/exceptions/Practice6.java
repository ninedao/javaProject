package com.lzc.thinkingInJava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Exception61 extends Exception {
    private static Logger logger = Logger.getLogger("Exception61");
    public Exception61(){
        StringWriter p = new StringWriter();
        printStackTrace(new PrintWriter(p));
        logger.severe(p.toString());
        logger.severe("\n");
    }

}
class Exception62 extends Exception {
    private static Logger logger = Logger.getLogger("Exception62");
    public Exception62() {
        StringWriter p = new StringWriter();
        printStackTrace(new PrintWriter(p));
        logger.severe(p.toString());
        logger.severe("\n");
    }

}
public class Practice6 {
    public static void main(String[] args) {
        try{
            throw new Exception61();
        } catch (Exception61 exception61) {
            exception61.printStackTrace();
        }

        try{
            throw new Exception62();
        } catch (Exception62 exception62) {
            exception62.printStackTrace();
        }
    }
}
