package com.lzc.thinkingInJava.concurrency;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class E14_ManyTimer {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10070; i++){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());
                }
            }, 1000 - i);
        }
        TimeUnit.SECONDS.sleep(2*100);
        System.exit(0);
    }
}
