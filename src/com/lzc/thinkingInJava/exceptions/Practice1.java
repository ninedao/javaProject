package com.lzc.thinkingInJava.exceptions;

class Practice1Exception extends Exception {
    public Practice1Exception() {}
    public Practice1Exception(String e) {
        super(e);
    }
}
public class Practice1 {
    public static void f() throws Practice1Exception {
        System.out.println("Throwing Practice1Exception from f()");
        throw new Practice1Exception("Originated in f()");
    }
    public static void main(String[] args){
        try {
            f();
        } catch(Practice1Exception e) {
            System.err.println("Caught Practice1Exception");
            e.printStackTrace();
        } finally {
            System.out.println("Made it to finally");
        }
    }
}
