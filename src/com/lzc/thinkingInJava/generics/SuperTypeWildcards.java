package com.lzc.thinkingInJava.generics;

import java.util.List;

public class SuperTypeWildcards {
    public static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit());
    }
}
