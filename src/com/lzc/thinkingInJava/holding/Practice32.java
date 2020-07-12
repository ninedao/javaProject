package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.*;


public class Practice32 extends PetSequence {
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>(){
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < pets.length;
            }

            @Override
            public Pet next() {
                return pets[i++];
            }
        };
    }
    public Iterable<Pet> reversed(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int i = pets.length - 1;
                    @Override
                    public boolean hasNext() {
                        return i > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[i--];
                    }
                };
            }
        };
    }
    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> list = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(list, new Random(47));
                return list.iterator();
            }
        };
    }
    public static void main(String[] args){
        Practice32 n = new Practice32();
        InterfaceVsIterator.display(n.iterator());
        InterfaceVsIterator.display(n.reversed().iterator());
        InterfaceVsIterator.display(n.randomized().iterator());
    }
}
