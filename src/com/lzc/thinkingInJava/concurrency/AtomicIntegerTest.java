package com.lzc.thinkingInJava.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);

    public AtomicIntegerTest() {
    }

    public AtomicIntegerTest(int i) {
        System.out.println(1);
    }

    public  int getVaule(){
        return i.get();
    }
    private synchronized void evenIncrement(){
        i.addAndGet(2);
    }
    @Override
    public void run() {
        evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest atomicityTest = new AtomicIntegerTest();
        executorService.execute(atomicityTest);
        while(true) {
            int val = atomicityTest.getVaule();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }


}
