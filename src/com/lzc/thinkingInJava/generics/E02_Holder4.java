package com.lzc.thinkingInJava.generics;

public class E02_Holder4<T> {
    private T a, b, c;

    public E02_Holder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }
    public static void main(String[] args) {
        E02_Holder4<Integer> s = new E02_Holder4<Integer>(1, 2, 3);
        System.out.println(s.getA());
        System.out.println(s.getB());
        System.out.println(s.getC());
        s.setC(4);
        System.out.println(s.getC());
    }
}
