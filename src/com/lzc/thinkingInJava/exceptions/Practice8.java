package com.lzc.thinkingInJava.exceptions;

class Exception8 extends Exception {
    private String msg;
    Exception8(String msg) {
        super(msg);
        System.out.println("Exception8()");
        this.msg = msg;
    }
    protected void showS() {
        System.out.println("Message from Exception8: " + msg);
    }
}

class Test8 {
    public static void f() throws Exception8 {
        System.out.println("f()");
        throw new Exception8("Ouch from f()");
    }
}
public class Practice8 {


    public static void main(String[] args){

        try {
            Test8.f();
        } catch (Exception8 exception8) {
            exception8.printStackTrace();
            exception8.showS();
        }

    }
}
