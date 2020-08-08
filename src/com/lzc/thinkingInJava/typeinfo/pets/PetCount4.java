package com.lzc.thinkingInJava.typeinfo.pets;

import com.lzc.thinkingInJava.typeinfo.TypeCounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter p = new TypeCounter(Pet.class);
        for(Pet pp : Pets.createArray(20)) {
            System.out.print(pp.getClass().getSimpleName() + " ");
            p.count(pp);
        }
        System.out.println();
        System.out.println(p);
    }
}
