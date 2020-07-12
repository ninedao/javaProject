package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int i = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return i > -1;
                    }

                    @Override
                    public T next() {
                        return get(i--);
                    }
                };
            }
        };
    }
    public static void main(String[] args){
        ReversibleArrayList<String> rList = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        for(String e : rList){
            System.out.print(e + " ");
        }
        System.out.println();
        for(String e : rList.reversed()){
            System.out.print(e + " ");
        }
    }
}
