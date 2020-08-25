package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
         //Collections.fill(flist, new Apple());
        //flist.set(0,new Object());
        //flist.add(new Apple());
        //flist.add(new Orange());
        //flist.add(new Fruit());
        //flist.add(new Object());
        flist.add(null);
        Fruit f = flist.get(0);
        System.out.println(f);
    }
}
