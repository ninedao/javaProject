package com.lzc.concurrent.chapter01;

import java.util.concurrent.TimeUnit;


public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::browswNews).start();
        enjoyMusic();
    }
    private static void browswNews(){
        for(;;){
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }
    private static void enjoyMusic(){
        for(;;){
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }
    private static void sleep(int secondes) {
        try {
            TimeUnit.SECONDS.sleep(secondes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
