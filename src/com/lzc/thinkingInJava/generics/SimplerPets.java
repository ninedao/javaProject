package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Person;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.util.New;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
    }
}
