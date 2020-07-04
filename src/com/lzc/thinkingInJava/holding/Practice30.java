package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;

import java.util.Collection;
import java.util.Iterator;



public class Practice30 implements Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

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
    public Object[] toArray() {
        return pets;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Pet pet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Pet> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        if(this.size() != 0){
            for(Pet p : pets){
                p =null;
            }
        }
    }
    public static void main(String[] args){
        Practice30 n = new Practice30();
        InterfaceVsIterator.display(n);
        InterfaceVsIterator.display(n.iterator());
    }
}
