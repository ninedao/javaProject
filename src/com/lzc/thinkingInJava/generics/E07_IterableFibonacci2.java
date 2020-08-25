package com.lzc.thinkingInJava.generics;

import java.util.Iterator;

class IterableFibonacci2 implements Iterable<Integer> {
    Fibonacci f = new Fibonacci();
    private int n = 0;
    public IterableFibonacci2(int count) {
        n = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0 ;
            }

            @Override
            public Integer next() {
                --n;
                return f.next();
            }
        };
    }
}
public class E07_IterableFibonacci2 {
    public static void main(String[] args) {
        for(Integer i : new IterableFibonacci2(18)){
            System.out.println(i);
        }
    }
}
