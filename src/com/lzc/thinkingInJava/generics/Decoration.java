package com.lzc.thinkingInJava.generics;

import java.util.Date;

class Basic1 {
    private String val;
    public void Set(String val) {
        this.val = val;
    }
    public String get() {
        return this.val;
    }
}
class Decorator extends Basic1 {
    protected Basic1 basic1;
    public Decorator(Basic1 basic1) {
        this.basic1 = basic1;
    }
    @Override
    public void Set(String val) {
        basic1.Set(val);
    }
    @Override
    public String get() {
        return basic1.get();
    }
}
class TimeStamped1 extends Decorator {
    private final long timeStamp;
    public TimeStamped1(Basic1 basic1) {
        super(basic1);
        this.timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}
class SerialNumbered1 extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumbered1(Basic1 basic1) {
        super(basic1);
    }
    public long getSerialNumber() {
        return serialNumber;
    }
}
public class Decoration {
    public static void main(String[] args) {
        TimeStamped1 t = new TimeStamped1(new Basic1());
        TimeStamped1 t2 = new TimeStamped1(new SerialNumbered1(new Basic1()));
        //t2.getSerialNumber();
        SerialNumbered1 t3 = new SerialNumbered1(new Basic1());
        SerialNumbered1 t4 = new SerialNumbered1(new TimeStamped1(new Basic1()));
        //t4.getStamp();
    }
}
