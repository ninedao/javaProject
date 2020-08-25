package com.lzc.thinkingInJava.generics;

import java.awt.*;
import java.util.Random;

interface E37_Colored {
    Color getColored();
}
class E37_ColoredImp implements E37_Colored {
    static Random rand = new Random(47);
    private final Color clr = new Color(rand.nextInt(16777216));
    @Override
    public Color getColored() {
        return clr;
    }
}

class Mixin1 extends BasicImp implements TimeStamped, SerialNumbered, E37_Colored {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumberedImp = new SerialNumberedImp();
    private E37_Colored e37_coloredImp = new E37_ColoredImp();
    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumberedImp.getSerialNumber();
    }

    @Override
    public Color getColored() {
        return e37_coloredImp.getColored();
    }
}

public class E37_Mixins2 {
    public static void main(String[] args) {
        Mixin1 mixin1 = new Mixin1(), mixin2 = new Mixin1();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin1.getColored());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + mixin2.getColored());
    }
}