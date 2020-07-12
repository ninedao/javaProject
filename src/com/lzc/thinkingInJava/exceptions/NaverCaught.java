package com.lzc.thinkingInJava.exceptions;

public class NaverCaught {
    public static void f(){
        throw new RuntimeException("From f()");
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }
    public static void main(String[] args){
        h();
    }
}
