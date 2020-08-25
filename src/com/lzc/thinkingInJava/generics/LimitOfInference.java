package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Mouse;
import com.lzc.thinkingInJava.typeinfo.pets.Person;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.util.New;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LimitOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
        //petPeople.put(1,1);
        petPeople.put(new Person("lzc"), Arrays.asList(new Mouse("Jack")));
        System.out.println(petPeople);
    }
    public static void main(String[] args) {
        Map map = New.map();
        map.put(1,1);
        f(map);
    }
}

