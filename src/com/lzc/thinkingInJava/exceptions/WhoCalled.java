package com.lzc.thinkingInJava.exceptions;

public class WhoCalled {
    public static void f(){
        try{
            throw new Exception();
        } catch(Exception e) {
            for(StackTraceElement elem : e.getStackTrace()){
                System.out.println(elem.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }
    public static void main(String[] args){
        f();
        System.out.println("-------------------------------");
        g();
        System.out.println("-------------------------------");
        h();
    }
}
