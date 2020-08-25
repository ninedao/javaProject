package com.lzc.thinkingInJava.generics;

public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('x');
        gm.f(gm);
    }
}
