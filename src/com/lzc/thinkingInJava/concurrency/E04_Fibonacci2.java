package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E04_Fibonacci2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 1; i < 6 ; i++){
            executorService.execute(new Fibonacci(i));
        }
        Thread.yield();
        executorService.shutdown();
        executorService = Executors.newFixedThreadPool(5);
        for(int i = 1; i < 6 ; i++){
            executorService.execute(new Fibonacci(i));
        }
        Thread.yield();
        executorService.shutdown();
        executorService = Executors.newSingleThreadExecutor();
        for(int i = 1; i < 6 ; i++){
            executorService.execute(new Fibonacci(i));
        }
        Thread.yield();
        executorService.shutdown();
    }
}
