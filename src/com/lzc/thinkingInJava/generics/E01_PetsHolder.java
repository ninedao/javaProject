package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Mouse;
import com.lzc.thinkingInJava.typeinfo.pets.Pet;

public class E01_PetsHolder {
    public static void main(String[] args) {
        Holder3<Pet> h = new Holder3<Pet>(new Mouse("Nick"));
        Mouse m = (Mouse) h.get();
        System.out.println(m);
        System.out.println(h.get());
    }
}
