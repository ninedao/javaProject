package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia ;
    @SuppressWarnings("unckecked")
    public static void main(String[] args) {
        // ClassCastException
        // gia = (Generic<Integer>[]) new Object[SIZE];
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        //gia[1] = new Object();
    }
}
