package com.lzc.thinkingInJava.holding;

import java.util.Collection;
import java.util.HashSet;

public class Practice2 {
    public static void main(String[] args){
        Collection<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < 3; i++){
            s.add(i);
            s.add(i);
        }
        for(Integer i : s){
            System.out.println(i);
        }
    }
}
