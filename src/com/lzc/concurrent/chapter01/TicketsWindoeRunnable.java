package com.lzc.concurrent.chapter01;

import java.util.stream.IntStream;

public class TicketsWindoeRunnable implements Runnable{
    private int index = 1;
    private final static int max = 50;
    @Override
    public void run() {
        while (index < max) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        final TicketsWindoeRunnable task = new TicketsWindoeRunnable();
//        Thread window1 = new Thread(task,"一号窗口");
//        Thread window2 = new Thread(task,"二号窗口");
//        Thread window3 = new Thread(task,"三号窗口");
//        Thread window4 = new Thread(task,"四号窗口");
//        window1.start();
//        window2.start();
//        window3.start();
//        window4.start();
        IntStream.range(0,5).boxed().map(i ->new Thread(()-> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);
    }
}
