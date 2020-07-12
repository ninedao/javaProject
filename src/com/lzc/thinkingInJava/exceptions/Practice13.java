package com.lzc.thinkingInJava.exceptions;

import java.util.Arrays;

import static com.lzc.thinkingInJava.util.Print.print;


public class Practice13 {
    private static Integer[] x = new Integer[1];
    public static void f(int i) throws Exception91, Exception92, Exception93{
        if(i < 0) throw new Exception91("x < 0");
        if(i == 0) throw new Exception92("x == 0");
        if(i > 0) throw new Exception93("x > 0");
    }
    public static void main(String[] args){
        try {
            f(x[0]);
            f(0);
            f(1);
            f(-1);
            // will catch any Exception type:
        } catch(Exception e) {
            System.out.println("Caught Exception");
            e.printStackTrace(System.out);
        }finally {
            print("made it to finally");
        }
    }
}
