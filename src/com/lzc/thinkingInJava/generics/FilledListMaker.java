package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> list = new ArrayList<T>();
        for(int i = 0; i < n; i++) {
            list.add(t);
        }
        return list;
    }
    public static void main(String[] args) {
        FilledListMaker<String> stringFilledListMaker = new FilledListMaker<String>();
        List<String> list = stringFilledListMaker.create("Hello", 4);
        System.out.println(list);
    }
}
