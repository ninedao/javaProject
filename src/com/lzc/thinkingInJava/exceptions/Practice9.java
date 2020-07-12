package com.lzc.thinkingInJava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.logging.Logger;
class Exception91 extends Exception{
    public Exception91(String msg) {
        super(msg);

    }
}
class Exception92 extends Exception{
    public Exception92(String msg) {
        super(msg);
        System.out.println(Arrays.toString(getStackTrace()));
    }
}
class Exception93 extends Exception{
    public Exception93(String msg) {
        super(msg);

    }
}
public class Practice9 {
    public static void f(int i) throws Exception91, Exception92, Exception93{
        if(i < 0) throw new Exception91("x < 0");
        if(i == 0) throw new Exception92("x == 0");
        if(i > 0) throw new Exception93("x > 0");
    }
    public static void main(String[] args){
        try {
            f(0);
            f(1);
            f(-1);
            // will catch any Exception type:
        } catch(Exception e) {
            System.out.println("Caught Exception");
            e.printStackTrace(System.out);
        }
    }
}
