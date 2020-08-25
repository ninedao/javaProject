package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class E27_GenericsAndCovariance1 {
    public static void main(String[] args) {
        List<? extends Number> flist = new ArrayList<Integer>();
        //flist.add(Integer.valueOf(1));
        //flist.add(new Object());
        flist = new ArrayList<Double>();
        flist.add(null);
        Integer f = (Integer) flist.get(0);
        System.out.println(f);
    }
}
