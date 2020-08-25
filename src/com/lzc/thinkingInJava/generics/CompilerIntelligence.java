package com.lzc.thinkingInJava.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> list = Arrays.asList(new Apple());
        Apple a = (Apple) list.get(0);
        list.contains(new Apple());
        list.indexOf(new Apple());
        System.out.println(list.toArray());
    }
}
