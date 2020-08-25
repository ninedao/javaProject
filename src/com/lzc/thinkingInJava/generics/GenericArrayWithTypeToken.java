package com.lzc.thinkingInJava.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unckecked")
    public  GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    public T[] rep() {
        return array;
    }
    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class,10);
        for(int i = 0; i < 10; i++) {
            gai.put(i, i);
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
