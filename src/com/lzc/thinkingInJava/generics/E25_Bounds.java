package com.lzc.thinkingInJava.generics;

interface Low{
    void c();
    void d();
}
class TopLowImpl implements Top, Low {

    @Override
    public void c() {
        System.out.println("Low.c()");
    }

    @Override
    public void d() {
        System.out.println("Low.d()");
    }

    @Override
    public void a() {
        System.out.println("Top.a()");
    }

    @Override
    public void b() {
        System.out.println("Top.b()");
    }
}
public class E25_Bounds {
    public static <T extends Top> void top(T t) {
        t.a();
        t.b();
    }
    public static <T extends Low>  void low(T t) {
        t.c();
        t.d();
    }
    public static void main(String[] args) {
        TopLowImpl tli = new TopLowImpl();
        top(tli);
        low(tli);
    }
}
