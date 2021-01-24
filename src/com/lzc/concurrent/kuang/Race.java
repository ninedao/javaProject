package com.lzc.concurrent.kuang;

import java.util.concurrent.TimeUnit;

public class Race implements Runnable {

    private static String WINNER;
    @Override
    public void run() {
        for(int i = 0; i <= 100; i++){
            if(Thread.currentThread().getName().equals("兔子") && i == 10){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i +"步");
        }
    }
    private boolean gameOver(int steps){
        if(WINNER != null){
            return true;
        }
        if(steps >= 100){
            WINNER = Thread.currentThread().getName();
            System.out.println("winner is " + WINNER);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
