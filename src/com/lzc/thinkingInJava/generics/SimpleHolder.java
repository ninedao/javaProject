package com.lzc.thinkingInJava.generics;

public class SimpleHolder {
    private Object obj;
    public void set(Object obj) {
        this.obj = obj;
    }
    public Object get() {
        return obj;
    }
    public static void main(String[] args) {
        SimpleHolder s = new SimpleHolder();
        s.set("Item");
        String str = (String) s.get();
    }
}
