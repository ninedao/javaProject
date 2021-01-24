package com.lzc.thinkingInJava.enumerated;

import java.util.EnumSet;

public class CarWash {
    public enum Cycle{
        UNDERBODY{
            @Override
            void action() {
                System.out.println("UNDERBODY.ACTION");
            }
        },WHEELWASH{
            @Override
            void action() {
                System.out.println("WHEELWASH.ACTION");
            }
        },PREWASH{
            @Override
            void action() {
                System.out.println("PREWASH.ACTION");
            }
        },BASIC{
            @Override
            void action() {
                System.out.println("BASIC.ACTION");
            }
        },HOTWAX{
            @Override
            void action() {
                System.out.println("HOTWAX.ACTION");
            }
        },RINSE{
            @Override
            void action() {
                System.out.println("RINSE.ACTION");
            }
        },BLOWDRY{
            @Override
            void action() {
                System.out.println("BLOWDRY.ACTION");
            }
        };
        abstract void action();
    }
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar(){
        for(Cycle c : cycles){
            c.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.RINSE);
        carWash.add(Cycle.HOTWAX);
        System.out.println(carWash);
        carWash.washCar();

    }
}
