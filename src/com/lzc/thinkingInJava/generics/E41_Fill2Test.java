package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.coffee.Coffee;
import com.lzc.thinkingInJava.generics.coffee.Latte;
import com.lzc.thinkingInJava.generics.coffee.Mocha;
import com.lzc.thinkingInJava.typeinfo.pets.Dog;
import com.lzc.thinkingInJava.typeinfo.pets.EgyptianMau;
import com.lzc.thinkingInJava.typeinfo.pets.Hamster;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class E41_Fill2Test {
    public static void main(String[] args) {
        List<Pet> carrier = new ArrayList<Pet>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier), Dog.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Hamster.class, 2);
        for(Pet c : carrier) {
            System.out.println(c);
        }
        System.out.println("---------------------------");

        AddableSimpleQueue<Pet> addableSimpleQueue = new AddableSimpleQueue<Pet>();
        Fill2.fill(addableSimpleQueue, EgyptianMau.class, 4);
        Fill2.fill(addableSimpleQueue, Hamster.class, 1);
        for(Pet c : addableSimpleQueue) {
            System.out.println(c);
        }
    }
}
