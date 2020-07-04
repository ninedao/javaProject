package com.lzc.thinkingInJava.holding;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how we konw the Earth to be banana-shaped.".split(" "));
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < words.length;
            }

            @Override
            public String next() {
                return words[i++];
            }
        };
    }
    public static void main(String[] args){
        for(String e : new IterableClass()){
            System.out.print(e + " ");
        }
    }
}
