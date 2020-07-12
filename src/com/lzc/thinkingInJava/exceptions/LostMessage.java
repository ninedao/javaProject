package com.lzc.thinkingInJava.exceptions;

class VeryImportantException extends Exception {}
class HoHumException extends Exception {}
public class LostMessage {
    public void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    public void g() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args){
        LostMessage l = new LostMessage();
        try {
            try {
                l.f();
            } finally {
                l.g();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
