package com.lzc.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadPriority {
    public static void main(String[] args) {
        final int[] i = {0};
        final int[] j = {0};
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                while(true) {
                    System.out.println("t1: " + (i[0]++));
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setPriority(3);

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                while(true) {
                    System.out.println("t2: " + (j[0]++));
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setPriority(10);

        t1.start();
        t2.start();
        System.out.println("id: " + t1.getId());
        t1.interrupt();
        t2.interrupt();
    }
}
