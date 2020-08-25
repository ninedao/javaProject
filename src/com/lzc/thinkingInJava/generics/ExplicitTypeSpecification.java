package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Person;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.util.New;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {}
    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
