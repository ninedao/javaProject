package com.lzc.thinkingInJava.generics;

public class E10_GenericMethods2 {
    public <A, B, C> void f(A x, B y, E10_GenericMethods2 z) {
        System.out.println("x : " + x.getClass().getName() + "; y : " + y.getClass().getName() + "; z : " + z.getClass().getName());
    }
    public static void main(String[] args) {
        E10_GenericMethods2 gm = new E10_GenericMethods2();
        gm.f(1, 1.0, gm);
    }
}
