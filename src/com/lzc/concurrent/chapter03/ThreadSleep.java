package com.lzc.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(()->{
            long startTime = System.currentTimeMillis();
            try {
                TimeUnit.MILLISECONDS.sleep(2_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms",(endTime - startTime)));
        }).start();

        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(3_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread spend %d ms",(endTime - startTime)));
    }
    public static void sleep(long ms) {
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
