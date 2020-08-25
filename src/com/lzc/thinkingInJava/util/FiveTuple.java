package com.lzc.thinkingInJava.util;

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E e;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        this.e = e;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "e=" + e +
                ", d=" + d +
                ", c=" + c +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
