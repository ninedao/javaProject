package com.lzc.thinkingInJava.generics;
interface FactoryI1<T> {
    T create(int arg);
}
class E23_Foo2<T> {
    private T x;
    public <F extends FactoryI1<T>> E23_Foo2 (F factory) {
        x = factory.create(1);
    }
}
class IntegerFactory1 implements FactoryI1<Integer> {

    @Override
    public Integer create(int arg) {
        return new Integer(0);
    }
}
class Widget1 {
    private final int id;

    Widget1(int arg) {
        id = arg;
    }

    public static class Factory implements FactoryI1<Widget1> {
        @Override
        public Widget1 create(int arg) {
            return new Widget1(arg);
        }
    }
}
public class E23_FactoryConstraint2 {
    public static void main(String[] args) {
        System.out.println(new E23_Foo2<Integer>(new IntegerFactory1()));
        System.out.println(new E23_Foo2<Widget1>(new Widget1.Factory()));
    }
}
