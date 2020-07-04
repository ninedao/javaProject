package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ": " + p.toString() + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets){
        for(Pet e : pets){
            System.out.print(e.id() + ": " + e.toString() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<Pet>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
        for(Pet e : petSet){
            petMap.put(String.valueOf(e.id()), e);
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        display(petMap.values());
        display(petMap.values().iterator());
    }
}
