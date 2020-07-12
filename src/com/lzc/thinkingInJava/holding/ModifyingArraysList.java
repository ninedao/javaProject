package com.lzc.thinkingInJava.holding;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.*;

public class ModifyingArraysList {
    public static void main(String[] args){
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("Before shuffing: " + list1);
        Collections.shuffle(list1, rand);
        System.out.println("Affter shuffing: " + list1);
        System.out.println("array: " + Arrays.asList(ia));

        List<Integer> list2 =Arrays.asList(ia);
        System.out.println("Before shuffing: " + list2);
        Collections.shuffle(list2, rand);
        System.out.println("Affter shuffing: " + list2);
        System.out.println("array: " + Arrays.asList(ia));
    }
}
