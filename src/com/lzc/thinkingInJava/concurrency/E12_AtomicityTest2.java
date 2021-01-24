package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Atomicity2 implements Runnable{
    int i;
    public  int getVaule(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public  void run() {
        evenIncrement();
    }
}
public class E12_AtomicityTest2  {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Atomicity2 at = new Atomicity2();
        executorService.execute(at);
        while(true){
            int i = at.getVaule();
            if(i % 2 != 0){
                System.out.println(i);
                System.exit(0);
            }
        }
    }


}
