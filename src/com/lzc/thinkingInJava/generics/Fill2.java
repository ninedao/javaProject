package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.coffee.Latte;
import com.lzc.thinkingInJava.generics.coffee.Coffee;
import com.lzc.thinkingInJava.generics.coffee.Mocha;
import com.lzc.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
    void add(T t);
}
public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> cls, int size) {
        for(int i = 0; i < size; i++) {
            try {
                addable.add(cls.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size){
        for(int i = 0; i < size; i++) {
            try {
                addable.add(generator.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> collection;
    public AddableCollectionAdapter(Collection<T> collection){
        this.collection = collection;
    }
    @Override
    public void add(T t) {
        collection.add(t);
    }
}
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) {
        super.add(t);
    }
}
class Fill2Test{
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for(Coffee c : carrier) {
            System.out.println(c);
        }
        System.out.println("---------------------------");

        AddableSimpleQueue<Coffee> addableSimpleQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(addableSimpleQueue, Mocha.class, 4);
        Fill2.fill(addableSimpleQueue, Latte.class, 1);
        for(Coffee c : addableSimpleQueue) {
            System.out.println(c);
        }
    }
}