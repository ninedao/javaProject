package com.lzc.thinkingInJava.innerclasses.controller;

public class GreenhouseController {
    public static void main(String[] args){
        GreenhouseControls gc = new GreenhouseControls();
        long time = System.nanoTime();
        gc.addEvent(gc.new Bell(900));
        Event[] events= {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, events));
        if(args.length > 0) {
            gc.addEvent(new GreenhouseControls.Terminate(0));
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(System.nanoTime() > time + 10000){
//                    System.exit(0);
//                }
//            }
//        }).start();
        gc.run();

    }
}
