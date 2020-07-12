package com.lzc.thinkingInJava.exceptions;
class Exception281 extends RuntimeException{
    private String msg;
    public Exception281(){}
    public Exception281(String s){
        super(s);
        System.out.println("Exception281()");
        msg =s;
    }
    public void showMsg(){
        System.out.println("Message from Exception4: " + msg);
    }
}

public class Practice28 {
    public static void f() throws Exception281 {
        System.out.println("f()");
        throw new Exception281("Ouch from f()");
    }
    public static void main(String[] args){
        f();
    }
}
