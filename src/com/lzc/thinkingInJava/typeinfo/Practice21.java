package com.lzc.thinkingInJava.typeinfo;

import java.util.Date;

import static com.lzc.thinkingInJava.util.Print.print;

interface Interface1 {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject1 implements Interface1 {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy1 implements Interface1 {
    private Interface1 proxied;
    private static int doCount = 0;
    private static int sECount = 0;
    public SimpleProxy1(Interface1 proxied) {
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        long timeIn = new Date().getTime();
        print("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
        print("on " + new Date());
        doCount++;
        proxied.doSomething();
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }

    @Override
    public void somethingElse(String arg) {
        long timeIn = new Date().getTime();
        print("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
        print("on " + new Date());
        sECount++;
        proxied.somethingElse(arg);
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
}

public class Practice21 {
    public static void consumer(Interface1 inter) {
        inter.doSomething();
        inter.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject1());
        System.out.println();
        consumer(new SimpleProxy1(new RealObject1()));
        System.out.println();
        consumer(new SimpleProxy1(new RealObject1()));
        System.out.println();
        consumer(new SimpleProxy1(new RealObject1()));
    }
}
