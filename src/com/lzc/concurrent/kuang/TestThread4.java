package com.lzc.concurrent.kuang;

import java.util.concurrent.TimeUnit;

public class TestThread4 implements Runnable {
    private int ticketnum = 30;
    @Override
    public void run() {
        while(true){
            if(ticketnum <= 0) {
                break;
            }
                System.out.println(Thread.currentThread().getName() + "拿到了第" + (ticketnum--) + "张票");
//            try {
//                TimeUnit.MILLISECONDS.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"小刘").start();
        new Thread(testThread4,"小张").start();
        new Thread(testThread4,"黄牛").start();

    }
}
