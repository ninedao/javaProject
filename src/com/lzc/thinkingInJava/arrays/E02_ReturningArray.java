package com.lzc.thinkingInJava.arrays;

import java.util.Arrays;

public class E02_ReturningArray {
    public static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[size];
        for(int i = 0; i < size; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }
        return berylliumSpheres;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(5)));
    }
}
