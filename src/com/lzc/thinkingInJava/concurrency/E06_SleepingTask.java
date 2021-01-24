package com.lzc.thinkingInJava.concurrency;

import com.mysql.cj.util.TimeUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SleepingTask2 implements Runnable{
    private static Random random = new Random();
    private final int i = random.nextInt(10) + 1;
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            System.out.println("Interrupted " + e);
        }
        System.out.println(i);
    }
}
public class E06_SleepingTask  {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            executorService.execute(new SleepingTask2());
        }
        executorService.shutdown();
    }
}
