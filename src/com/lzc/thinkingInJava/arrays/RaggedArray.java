package com.lzc.thinkingInJava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RaggedArray {
    static Random random = new Random(47);
    public static void main(String[] args) {
        int[][][] a = new int[random.nextInt(7)][][];
        for(int i = 0; i < a.length ; i++) {
            a[i] = new int[random.nextInt(5)][];
            for(int j = 0; j < a[i].length; j++){
                a[i][j] = new int[random.nextInt(5)];
            }
        }
        List[] lists = new ArrayList[5];
        System.out.println(Arrays.deepToString(a));
    }
}
