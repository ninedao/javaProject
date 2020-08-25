package com.lzc.thinkingInJava.generics;


import com.lzc.thinkingInJava.innerclasses.Sequence;
import com.lzc.thinkingInJava.util.FiveTuple;
import com.lzc.thinkingInJava.util.New;

import java.util.List;

public class E11_NewTest {
    public static void main(String[] args) {
        List<FiveTuple<Vehicle, Amphibian, String, Integer, Double>> list = New.list();
        list.add(new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(),"hi", 47, 1.11));
        System.out.println(list);
    }
}
