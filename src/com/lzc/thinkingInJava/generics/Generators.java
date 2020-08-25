package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.coffee.Coffee;
import com.lzc.thinkingInJava.generics.coffee.CoffeeGenerator;
import com.lzc.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++){
            coll.add(generator.next());
        }
        return coll;
    }
    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        System.out.println(coffee);
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        System.out.println(fnumbers);
    }
}
