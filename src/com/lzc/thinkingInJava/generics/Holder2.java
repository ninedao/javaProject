package com.lzc.thinkingInJava.generics;

public class Holder2 {
    private Object o;
    public Holder2(Object o) {
        this.o = o;
    }
    public void set(Object o) {
        this.o = o;
    }
    public Object get() {
        return o;
    }
    public static void main(String[] args) {
        Holder2 h = new Holder2(new Automobile());
        Automobile a = (Automobile) h.get();
        h.set("Not an Automobile");
        String s = (String) h.get();
        h.set(1);
        Integer x = (Integer) h.get();
    }
}
