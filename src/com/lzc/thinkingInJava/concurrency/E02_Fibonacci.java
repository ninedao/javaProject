package com.lzc.thinkingInJava.concurrency;

import com.lzc.thinkingInJava.util.Generator;

import java.util.Arrays;

class Fibonacci implements Generator<Integer>, Runnable{
    private final int n;
    private int count = 1;
    private int[] flag;
    public Fibonacci(int n) {
        this.n = n;
        flag = new int[n + 1];
    }
    public int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }else{
            if(flag[n-1] == 0){
                flag[n-1] = fib(n-1);
            }
            if(flag[n-2] == 0){
                flag[n-2] =  fib(n - 2);
            }
            return flag[n-1] + flag[n-2];
        }
    }
    @Override
    public Integer next() {
        return fib(count++);
    }

    @Override
    public void run() {
        Integer[] sequence = new Integer[n];
        for(int i = 0; i < n; i++){
            sequence[i] = next();
        }
        System.out.println("Seq. of " + n +": " + Arrays.toString(sequence));
    }
}
public class E02_Fibonacci {
    public static void main(String[] args) {
        for(int i = 1; i <= 30; i++) {
            new Thread(new Fibonacci(i)).start();
        }
    }
}
