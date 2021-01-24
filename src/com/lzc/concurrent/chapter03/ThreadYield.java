package com.lzc.concurrent.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadYield {
    public static void main(String[] args) {
        //IntStream.range(0,2).mapToObj(ThreadYield::crteate).forEach(Thread::start);

        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("interrupted still");
        }
    }
    private static Thread crteate(int index) {
        return new Thread(() ->{
            if(index == 0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
