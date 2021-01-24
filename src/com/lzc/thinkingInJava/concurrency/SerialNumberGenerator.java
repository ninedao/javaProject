package com.lzc.thinkingInJava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int  nextSerialNumber(){
        return serialNumber++;

    }

}
