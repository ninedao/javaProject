package com.lzc.thinkingInJava.generics;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }
    public void push(T item) {
        storage[index++] = item;
    }
    public T pop(){
        return (T) storage[--index];
    }
}
public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> fixedSizeStack = new FixedSizeStack<String>(SIZE);
        for(String s : "A B C D E F G H I J".split(" ")){
            fixedSizeStack.push(s);
        }
        for(int i = 0; i < SIZE; i++) {
            System.out.print(fixedSizeStack.pop() + " ");
        }
    }
}
