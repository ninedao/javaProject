package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Cat;
import com.lzc.thinkingInJava.typeinfo.pets.Dog;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<Dog>();
        oldStyleMethod(dogs);
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
