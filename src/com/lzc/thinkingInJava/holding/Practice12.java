package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Practice12 {
    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator it1 = l1.listIterator(5);
        ListIterator it2 = l2.listIterator();
        while(it1.hasPrevious()){
            it2.next();
            it2.set(it1.previous());
        }
        System.out.println(l1);
        System.out.println(l2);
    }
}
