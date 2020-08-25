package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

public class E14_BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for(int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
