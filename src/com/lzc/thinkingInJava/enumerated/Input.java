package com.lzc.thinkingInJava.enumerated;

import java.util.Random;

public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        @Override
        int amount() {
            throw new RuntimeException("Action.amount");
        }
    },
    STOP{
        @Override
        int amount() {
            throw new RuntimeException("STOP.amount");
        }
    };
    int value;
    Input(int value){
        this.value = value;
    }
    Input(){};
    int amount(){
        return value;
    }
    static Random random = new Random(47);
    public static Input randomSelection(){
        return values()[random.nextInt(values().length - 1)];
    }
}
