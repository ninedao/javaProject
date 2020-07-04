package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Cat;
import com.lzc.thinkingInJava.typeinfo.pets.Dog;
import com.lzc.thinkingInJava.typeinfo.pets.Hamster;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetMap {
    public static void main(String[] args){
        Map<String, Pet> map = new HashMap<String, Pet>();
        map.put("My Cat", new Cat("Molly"));
        map.put("My Dog", new Dog("Ginger"));
        map.put("My Hamster", new Hamster("Bosco"));
        System.out.println(map);
        Pet dog = map.get("My Dog");
        System.out.println(dog);
        System.out.println(map.containsKey("My Dog"));
        System.out.println(map.containsValue(dog));
    }
}
