package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class FullStackException extends RuntimeException{}
class FixedSizeStack2<T> {
    private int index = 0;
    private final int size;
    private List<T> storage;
    public FixedSizeStack2(int size) {
        storage = new ArrayList<T>(size);
        this.size = size;
    }
    public void push(T item) {
        if(index < size) {
            storage.add(item);
            index++;
        }else{
            throw  new FullStackException();
        }
    }
    public T pop(){
        if(index > 0){
            index--;
            return storage.get(index);
        }
        throw new EmptyStackException();
    }
}

public class E33_GenericCast2 {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack2<String> fixedSizeStack = new FixedSizeStack2<String>(SIZE);
        for(String s : "A B C D E F G H I J".split(" ")){
            fixedSizeStack.push(s);
        }
        for(int i = 0; i < 11; i++) {
            System.out.print(fixedSizeStack.pop() + " ");
        }
    }
}
