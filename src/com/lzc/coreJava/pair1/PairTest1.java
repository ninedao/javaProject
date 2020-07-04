package com.lzc.coreJava.pair1;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Queue;

public class PairTest1 {
    public static void main(String[] args){
        String[] a = {"Mary", "had", "a", "little", "lamb"};
        Pair p = ArrayAlg.minmax(a);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
        System.out.println(ArrayAlg.min(a));
        double middle = ArrayAlg.add(1.1, 2.0, null);
    }
}
class ArrayAlg{
    public static <T> T add(T ... c){
        return c[c.length/2];
    }
    public static <T extends Comparable  > T min(T[] a){
        if(a == null || a.length == 0){
            return null;
        }
        T max = a[0];
        T min = a[0];
        for(T element : a){
            if(max.compareTo(element) < 0){
                max = element;
            }
            if(min.compareTo(element) > 0){
                min = element;
            }
        }
        return min;
    }
    public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0){
            return null;
        }
        String max = a[0];
        String min = a[0];
        for(String element : a){
            if(max.compareTo(element) < 0){
                max = element;
            }
            if(min.compareTo(element) > 0 ){
                min = element;
            }
        }
        return new Pair<>(min, max);
    }
}
class Pair<T>{
    private T first;
    private T second;
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}