package com.lzc.thinkingInJava.exceptions;



public class Practice19 {
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
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                l.g();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
