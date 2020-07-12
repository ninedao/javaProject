package com.lzc.thinkingInJava.exceptions;
class Exception4 extends Exception{
    private String msg;
    public Exception4(){}
    public Exception4(String s){
        super(s);
        System.out.println("Exception4()");
        msg =s;
    }
    public void showMsg(){
        System.out.println("Message from Exception4: " + msg);
    }
}
public class Practice4 {
    public static void f() throws Exception4 {
        System.out.println("f()");
        throw new Exception4("Ouch from f()");
    }
    public static void main(String[] args){
        try {
            f();
        } catch(Exception4 e) {
            System.err.println("Caught Exception4");
            e.printStackTrace();
            e.showMsg();
        }
    }
}
