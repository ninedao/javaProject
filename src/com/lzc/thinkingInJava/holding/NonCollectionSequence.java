package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.Iterator;

class PetSequence{
    protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence extends PetSequence{
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
    public static void main(String[] args){
        NonCollectionSequence n = new NonCollectionSequence();
        InterfaceVsIterator.display(n.iterator());
    }
}
