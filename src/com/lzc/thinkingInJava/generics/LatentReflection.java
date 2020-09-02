package com.lzc.thinkingInJava.generics;

import java.lang.reflect.Method;

class Mime {
    public void walkAgainstTheWind() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls(){}

    @Override
    public String toString() {
        return "Mime";
    }
}
class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce() {}
}
class CommunicateReflectively {
    public static void perform(Object spearker) {
        Class<?> cls = spearker.getClass();
        try {
            try {
                Method method = cls.getMethod("speak");
                method.invoke(spearker);
            } catch (Exception e) {
                System.out.println(spearker + " cannot speak");
            }
            try {
                Method method = cls.getMethod("sit");
                method.invoke(spearker);
            } catch (Exception e) {
                System.out.println(spearker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(spearker.toString(), e);
        }
    }
}
public class LatentReflection {
    public static void main(String[] args) {
        Mime mime = new Mime();
        SmartDog smartDog = new SmartDog();
        CommunicateReflectively.perform(mime);
        CommunicateReflectively.perform(smartDog);
    }
}
