package com.lzc.thinkingInJava.typeinfo;

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
/*java.lang.InstantiationException: com.lzc.thinkingInJava.typeinfo.Toy
	at java.lang.Class.newInstance(Class.java:427)
	at com.lzc.thinkingInJava.typeinfo.Practice1.main(Practice1.java:45)
Caused by: java.lang.NoSuchMethodException: com.lzc.thinkingInJava.typeinfo.Toy.<init>()
	at java.lang.Class.getConstructor0(Class.java:3082)
	at java.lang.Class.newInstance(Class.java:412)
	... 1 more
Exception in thread "main" java.lang.NullPointerException
	at com.lzc.thinkingInJava.typeinfo.Practice1.main(Practice1.java:51)*/
public class Practice1 {
    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() + " is interface ? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.lzc.thinkingInJava.typeinfo.FancyToy");
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
