package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private  int i = 0;

    public AtomicityTest() {
    }

    public AtomicityTest(int i) {
        System.out.println(1);
    }

    public  int getVaule(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {

        while(true) {
            evenIncrement();
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
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
