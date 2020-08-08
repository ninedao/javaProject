package com.lzc.thinkingInJava.typeinfo;

interface iPractice2 {}
class Toy2 {
    Toy2() {}
    Toy2(int i) {}
}
class FancyToy2 extends Toy2 implements HasBaterries, WaterProof, Shoots, iPractice2 {
    FancyToy2() {
        super(1);
    }
}

public class Practice2 {
    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() + " is interface ? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.lzc.thinkingInJava.typeinfo.FancyToy2");
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
            /*
            * 报错是newInstance()方法是调用无参构造方法
            * */
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());

    }
}
