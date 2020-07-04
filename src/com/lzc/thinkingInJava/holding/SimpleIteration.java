package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleIteration {
    public static void main(String[] args){
        List<Pet> list = Pets.arrayList(12);
        Iterator<Pet> it = list.iterator();
        while(it.hasNext()){
            Pet pt = it.next();
            System.out.print(pt.id() + ":" + pt + " ");
        }
        System.out.println();
        for(Pet pt : list){
            System.out.print(pt.id() + ":" + pt + " ");
        }
        System.out.println();
        it = list.iterator();
        for(int i = 0; i < 6; i++){
            it.next();
            it.remove();
        }
        System.out.println(list);
    }
}
