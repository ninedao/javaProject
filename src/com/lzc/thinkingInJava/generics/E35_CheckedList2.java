package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.coffee.Americano;
import com.lzc.thinkingInJava.generics.coffee.Cappuccino;
import com.lzc.thinkingInJava.generics.coffee.Coffee;
import com.lzc.thinkingInJava.typeinfo.pets.Cat;
import com.lzc.thinkingInJava.typeinfo.pets.Dog;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E35_CheckedList2 {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Americano());
    }
    public static void main(String[] args) {
        List<Cappuccino> cappuccinos = new ArrayList<Cappuccino>();
        oldStyleMethod(cappuccinos);
        List<Cappuccino> cappuccino2 = Collections.checkedList(new ArrayList<Cappuccino>(), Cappuccino.class);
        try {
            oldStyleMethod(cappuccino2);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<Coffee> coffees = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        coffees.add(new Cappuccino());
        coffees.add(new Americano());
    }
}
