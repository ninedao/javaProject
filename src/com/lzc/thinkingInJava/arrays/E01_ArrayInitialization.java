package com.lzc.thinkingInJava.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E01_ArrayInitialization {
    public static void print(BerylliumSphere[] a) {
        for(BerylliumSphere b : a) {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        print(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
        List[] s = new List[10];
        //print({new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
    }
}
