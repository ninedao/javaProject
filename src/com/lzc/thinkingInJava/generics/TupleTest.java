package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.FiveTuple;
import com.lzc.thinkingInJava.util.FourTuple;
import com.lzc.thinkingInJava.util.ThreeTuple;
import com.lzc.thinkingInJava.util.TwoTuple;

class Amphibian {}
class Vehicle {}
public class TupleTest {
    static TwoTuple<String, Integer> f(){
        return new TwoTuple<String, Integer>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g(){
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h(){
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(),"hi", 47);
    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k(){
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(),"hi", 47, 1.11);
    }
    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        //ttsi.a = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
