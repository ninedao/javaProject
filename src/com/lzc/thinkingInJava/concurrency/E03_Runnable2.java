package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03_Runnable2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5 ; i++){
            executorService.execute(new Printer());
        }
        Thread.yield();
        executorService.shutdown();
        executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5 ; i++){
            executorService.execute(new Printer());
        }
        Thread.yield();
        executorService.shutdown();
        executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5 ; i++){
            executorService.execute(new Printer());
        }
        Thread.yield();
        executorService.shutdown();
    }
}
