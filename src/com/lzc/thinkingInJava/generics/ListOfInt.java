package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 20; i++) {
            list.add(i);
        }
        for(int i : list) {
            System.out.println(i);
        }
    }
}
