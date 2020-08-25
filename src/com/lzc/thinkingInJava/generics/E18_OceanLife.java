package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

import java.util.*;

class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    private BigFish(){}
    @Override
    public String toString() {
        return "BigFish " + id;
    }
    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish(){}
    @Override
    public String toString() {
        return "LittleFish " + id;
    }
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}

public class E18_OceanLife {
    public static void eat(BigFish t, LittleFish c) {
        System.out.println(t + " eat " + c);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<LittleFish> littleFish = new LinkedList<LittleFish>();
        Generators.fill(littleFish, LittleFish.generator(), 15);
        List<BigFish> bigFish = new ArrayList<BigFish>();
        Generators.fill(bigFish, BigFish.generator(), 4);
        for(LittleFish c : littleFish) {
            eat(bigFish.get(rand.nextInt(bigFish.size())), c);
        }
    }
}
