package com.lzc.thinkingInJava.generics;

public class E09_GenericMethods1 {
    public <A, B, C> void f(A x, B y, C z) {
        System.out.println("x : " + x.getClass().getName() + "; y : " + y.getClass().getName() + "; z : " + z.getClass().getName());
    }
    public static void main(String[] args) {
        E09_GenericMethods1 gm = new E09_GenericMethods1();
        gm.f(1, 1.0, gm);
    }
}
