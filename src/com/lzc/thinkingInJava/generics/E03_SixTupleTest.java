package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.SixTuple;

public class E03_SixTupleTest {
    public static SixTuple<Vehicle, Amphibian, String, Integer, Double, Byte> k() {
        return new SixTuple<Vehicle, Amphibian, String, Integer, Double, Byte>(new Vehicle(), new Amphibian(),"hi", 47, 1.11, (byte) 1);
    }
    public static void main(String[] args) {
        System.out.println(k());
    }
}
