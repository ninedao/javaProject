package com.lzc.thinkingInJava.exceptions;

class SimpleException extends Exception{}
public class InheritingException {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args){
        InheritingException in = new InheritingException();
        try {
            in.f();
        } catch (SimpleException e) {
            e.printStackTrace();
        }
    }
}
