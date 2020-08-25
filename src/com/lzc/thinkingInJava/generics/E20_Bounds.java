package com.lzc.thinkingInJava.generics;

interface Top{
    void a();
    void b();
}
class CombinedImpl implements Top {

    @Override
    public void a() {
        System.out.println("Top.a()");
    }

    @Override
    public void b() {
        System.out.println("Top.b()");
    }
    public void c() {
        System.out.println("CombinedImpl.c()");
    }
}
public class E20_Bounds {
    public static <T extends Top> void f(T t){
        t.a();
        t.b();
        //t.c();
    }
    public static void main(String[] args) {
        f(new CombinedImpl());
    }
}
