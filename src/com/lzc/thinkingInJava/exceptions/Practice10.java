package com.lzc.thinkingInJava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
class Exception10 extends Exception{
    public Exception10(){}
    public Exception10(String msg){
        super(msg);
    }
}
class Exception101 extends Exception{
    public Exception101(){}
    public Exception101(String msg){
        super(msg);
    }
}
public class Practice10 {
    static void g() throws Exception10 {
        throw new Exception10("123");
    }
    static void f(){
        try {
            try {
                g();
            } catch (Exception10 exception10) {
                exception10.printStackTrace();
                throw new Exception101("111");
            }
        } catch (Exception101 e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        f();
    }
}
