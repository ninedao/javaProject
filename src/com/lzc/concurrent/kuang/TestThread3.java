package com.lzc.concurrent.kuang;

public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 200; i++){
            System.out.println("我在看代码--" + i);
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        Thread thread = new Thread(testThread3);
        thread.start();

        for(int i = 0; i < 1000; i++){
            System.out.println("我在学习多线程--" + i);
        }
    }
}
