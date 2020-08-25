package com.lzc.thinkingInJava.util;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D d;
    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "d=" + d +
                ", c=" + c +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
