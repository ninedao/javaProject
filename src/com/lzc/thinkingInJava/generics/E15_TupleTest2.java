package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.*;

public class E15_TupleTest2 {
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
    public static void main(String[] args) {
        //Information:java: /C:/LocalFiles/project/IdeaProjects/javaProject/src/com/lzc/thinkingInJava/generics/E15_TupleTest2.java使用了未经检查或不安全的操作。
        //Information:java: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
        TwoTuple<String, Integer> ttsi = f2();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
