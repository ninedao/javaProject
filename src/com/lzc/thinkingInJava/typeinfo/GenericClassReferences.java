package com.lzc.thinkingInJava.typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intclass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intclass = double.class;
    }
}
