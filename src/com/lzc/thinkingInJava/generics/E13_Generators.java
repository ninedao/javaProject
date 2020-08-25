package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.coffee.Coffee;
import com.lzc.thinkingInJava.generics.coffee.CoffeeGenerator;
import com.lzc.thinkingInJava.util.Generator;

import java.util.*;

public class E13_Generators {
    public static <T> List<T> fill(List<T> coll, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++){
            coll.add(generator.next());
        }
        return coll;
    }
    public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++){
            coll.add(generator.next());
        }
        return coll;
    }
    public static <T> Queue<T> fill(Queue<T> coll, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++){
            coll.add(generator.next());
        }
        return coll;
    }
    public static <T> Set<T> fill(Set<T> coll, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++){
            coll.add(generator.next());
        }
        return coll;
    }
    public static void main(String[] args) {
        List<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for(Coffee i : coffee) {
            System.out.println(i);
        }
        Queue<Integer> integer = fill((Queue<Integer>)new LinkedList<Integer>(), new Fibonacci(), 12);
        for(Integer i : integer) {
            System.out.println(i);
        }
        LinkedList<Integer> integer1 = fill(new LinkedList<Integer>(), new Fibonacci(), 12);
        for(Integer i : integer1) {
            System.out.println(i);
        }

        Set<Integer> integer2 = fill(new HashSet<Integer>(), new Fibonacci(), 12);
        for(Integer i : integer2) {
            System.out.println(i);
        }
    }
}
