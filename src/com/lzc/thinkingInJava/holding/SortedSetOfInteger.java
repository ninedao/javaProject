package com.lzc.thinkingInJava.holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < 10000; i++) {
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
    }
}
