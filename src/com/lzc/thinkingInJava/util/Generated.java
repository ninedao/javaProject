package com.lzc.thinkingInJava.util;

import java.lang.reflect.Array;

public class Generated {
    public static <T> T[] array(T[] a, Generator<T> generator) {
        return  new CollectionData<T>(generator, a.length).toArray(a);
    }
    public static <T> T[] array(Class<T> type, Generator<T> generator, int quantity) {
        T[] t = (T[])Array.newInstance(type, quantity);
        return new CollectionData<T>(generator,quantity).toArray(t);
    }
}
