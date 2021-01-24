package com.lzc.concurrent.chapter02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCount extends Thread {
    final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try{
            while(true) {
                new ThreadCount().start();
            }
        }catch (Throwable e) {
            System.out.println(counter.get());
        }
    }
    @Override
    public void run() {
        try{
            System.out.println("Thread " + counter.getAndIncrement() + " thread be created.");
            TimeUnit.MILLISECONDS.sleep(10);
            sleep(2_000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
