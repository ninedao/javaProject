package com.lzc.thinkingInJava.holding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Practice14 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListIterator it = list.listIterator();
        for(int i = 0; i < 10; i++) {
            it = list.listIterator(list.size()/2);
            it.add(i);
        }
        System.out.println(list);
    }
}
