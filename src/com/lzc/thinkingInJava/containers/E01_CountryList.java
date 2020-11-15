package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class E01_CountryList {
    private static Random rand = new Random(47);
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>(Countries.names(5));
        Collections.sort(l);
        System.out.println("sort :" + l);
        for(int i = 0; i < 5; i++) {
            Collections.shuffle(l,rand);
            System.out.println("shuffle" + i + " :" + l);
        }
    }
}
