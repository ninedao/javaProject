package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.*;

public class CrossContainerInteration {
    public static void diaplay(Iterator<Pet> it){
        while(it.hasNext()){
            Pet pt = it.next();
            System.out.print(pt.id() + ":" + pt + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petList = new LinkedList<Pet>(pets);
        HashSet<Pet> petHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petTS= new TreeSet<Pet>(pets);
        diaplay(pets.iterator());
        diaplay(petList.iterator());
        diaplay(petHS.iterator());
        diaplay(petTS.iterator());

    }
}
