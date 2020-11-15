package com.lzc.thinkingInJava.arrays;

import com.lzc.thinkingInJava.util.Generated;
import com.lzc.thinkingInJava.util.RandomGenerator;

import java.util.Arrays;
import java.util.Map;

public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println(index);
    }
}
