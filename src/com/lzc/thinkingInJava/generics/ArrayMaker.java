package com.lzc.thinkingInJava.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    public Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }
    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
        System.out.println(stringMaker.kind);
    }
}
