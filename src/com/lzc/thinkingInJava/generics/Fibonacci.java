package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    private Integer fib(int n) {
        if(n < 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    @Override
    public Integer next() {
        return fib(count++);
    }
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for(int i = 0; i < 200; i++) {
            System.out.println(f.next() + " ");
        }
    }
}
