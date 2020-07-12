package com.lzc.thinkingInJava.exceptions;


class Exception181 extends Exception {}
public class Practice18 {
    public void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    public void g() throws HoHumException {
        throw new HoHumException();
    }
    public void m() throws Exception181 {
        throw new Exception181();
    }
    public static void main(String[] args){
        Practice18 l = new Practice18();
        try {
            try {
                try {
                    l.f();
                } finally {
                    l.g();
                }
            } finally {
                l.m();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
