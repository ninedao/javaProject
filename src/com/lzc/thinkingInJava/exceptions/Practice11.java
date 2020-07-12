package com.lzc.thinkingInJava.exceptions;


import java.io.IOException;

public class Practice11 {
    static void g() throws Exception10 {
        throw new Exception10("123");
    }
    static void f(){
        try {
            try {
                g();
            } catch (Exception10 exception10) {
                exception10.printStackTrace();
                throw new RuntimeException(exception10);
            }
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        f();
    }
}
