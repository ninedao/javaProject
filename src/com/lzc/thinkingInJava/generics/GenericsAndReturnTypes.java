package com.lzc.thinkingInJava.generics;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}
interface Getter extends GenericGetter<Getter> {}
public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter g1 = g.get();
        GenericGetter g2 = g.get();
    }
    public static void main(String[] args) {

    }
}
