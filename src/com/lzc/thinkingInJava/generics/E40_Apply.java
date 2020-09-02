package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.*;
import com.lzc.thinkingInJava.typeinfo.pets.Hamster;

import java.util.Arrays;
import java.util.List;

public class E40_Apply {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Pet> pets =  Arrays.asList(new Rat(), new Pug(), new Mutt(),
                new Mouse(), new Manx(), new Hamster(), new EgyptianMau(), new Cymric());
        Apply.apply( pets , Pet.class.getMethod("speak"));
    }
}
