package com.lzc.thinkingInJava.exceptions;

public class Rethrowing {
    public static void f() throws Exception{
        System.out.println("originating th exception in f()");
        throw new Exception("throw from f()");
    }
    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(), e.PrinStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception{
        try {
            g();
        } catch (Exception e) {
            System.out.println("Inside h(), e.PrinStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }
    public static void main(String[] args){

        try {
            g();
        } catch (Exception e) {
            System.out.println("main: PrinStrackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: PrinStrackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
