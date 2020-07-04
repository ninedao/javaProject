package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
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

    @Override
    public int size() {
        return  pets.length;
    }
    public static void main(String[] args){
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
