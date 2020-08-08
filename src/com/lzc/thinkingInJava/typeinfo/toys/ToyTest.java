package com.lzc.thinkingInJava.typeinfo.toys;

import java.awt.*;

interface HasBaterries {}
interface WaterProof {}
interface Shoots {}
class Toy {
    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBaterries, WaterProof, Shoots {
    FancyToy() {
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() + " is interface ? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.lzc.thinkingInJava.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        for(Class e : c.getInterfaces()) {
            printInfo(e);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());
    }
}
