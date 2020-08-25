package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

class Farry{
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for(int i = 0; i < a.length; i++) {
            a[i] = gen.next();
        }
        return a;
    }
}
public class PrimitiveGenericTest {
    public static void main(String[] args) {

    }
}
