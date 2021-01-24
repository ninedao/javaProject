package com.lzc.thinkingInJava.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Tank {
    enum STATUS{EMPTY,LOADED};
    private STATUS status = STATUS.EMPTY;
    private int current_load = 0;
    public synchronized void validate(){
        if(status == STATUS.EMPTY && current_load != 0 || status == STATUS.LOADED && current_load == 0){
            throw new IllegalArgumentException();
        }
    }
    public synchronized void fill(){
        status = STATUS.LOADED;
        Thread.yield();
        current_load = 10;
    }
    public synchronized void drain(){
        status = STATUS.EMPTY;
        Thread.yield();
        current_load = 0;
    }
}
class ConsistencyChecker implements Runnable{
    private static Random random = new Random();
    private Tank tank;

    public ConsistencyChecker(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void run() {
        for(;;){
            if(random.nextBoolean()){
                tank.fill();
            }else{
                tank.drain();
            }
            tank.validate();
        }
    }
}
public class E11_RaceCondition {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService service = Executors.newCachedThreadPool();
        Tank tank = new Tank();
        for(int i = 0; i < 1000; i++){
            service.execute(new ConsistencyChecker(tank));
        }
        Thread.yield();
        service.shutdown();
    }
}
