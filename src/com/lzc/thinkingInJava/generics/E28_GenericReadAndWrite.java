package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Cat;
import com.lzc.thinkingInJava.typeinfo.pets.Mouse;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Rodent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Generic1<T> {
    public void set(T arg) {}
}
class Generic2<T> {
    public T get() {
        return null;
    }
}
public class E28_GenericReadAndWrite {
    static <T> void f1(Generic1<? super T> obj, T item) {
        obj.set(item);
    }
    static <T> T f2(Generic2<? extends T> obj) {
        return obj.get();
    }
    public static void main(String[] args) {
        Generic1<Rodent> g1 = new Generic1<Rodent>();
        f1(g1, new Mouse());
        //f1(g1, new Cat());
        Generic2<Pet> g2 = new Generic2<Pet>();
        Pet pet = f2(g2);
        Generic2<Cat> g3 = new Generic2<Cat>();
        Cat cat = f2(g3);
        pet = f2(g3);
    }
}
