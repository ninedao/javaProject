package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class SerialNumberGenerator2 {
    private static volatile int serialNumber = 0;
    public synchronized static int  nextSerialNumber(){
        return serialNumber++;

    }

}

public class E13_SerialNumberChecker2 {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable{
        @Override
        public void run() {
            while(true) {
                int serial = SerialNumberGenerator2.nextSerialNumber();
                if(circularSet.constains(serial)){
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                circularSet.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        args = new String[]{"4"};
        for(int i = 0; i < SIZE; i++){
            executorService.execute(new SerialChecker());
        }
        if(args.length > 0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}
