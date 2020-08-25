package com.lzc.thinkingInJava.generics;

public class Holder3<T> {
    private T o;
    public Holder3(T o) {
        this.o = o;
    }
    public void set(T o) {
        this.o = o;
    }
    public T get() {
        return o;
    }
    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get();
        //h3.set("Not an Automobile");
    }
}
