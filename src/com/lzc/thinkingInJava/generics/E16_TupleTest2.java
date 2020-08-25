package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.*;

public class E16_TupleTest2 {
    static TwoTuple<String, Integer> f(){
        return Tuple.tuple("hi", 47);
    }
    static TwoTuple f2(){
        return Tuple.tuple("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle,Amphibian, String, Integer> h() {
        return Tuple.tuple(new Vehicle(),new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle,Amphibian, String, Integer,Double> k() {
        return Tuple.tuple(new Vehicle(),new Amphibian(), "hi", 47,1.1);
    }
    static SixTuple<Vehicle,Amphibian, String, Integer,Double,Character> m() {
        return Tuple.tuple(new Vehicle(),new Amphibian(), "hi", 47,1.1,'A');
    }
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(m());
    }
}
