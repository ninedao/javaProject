package com.lzc.thinkingInJava.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "com.lzc.thinkingInJava.typeinfo.pets.Mutt",
            "com.lzc.thinkingInJava.typeinfo.pets.Pug",
            "com.lzc.thinkingInJava.typeinfo.pets.EgyptianMau",
            "com.lzc.thinkingInJava.typeinfo.pets.Manx",
            "com.lzc.thinkingInJava.typeinfo.pets.Cymric",
            "com.lzc.thinkingInJava.typeinfo.pets.Rat",
            "com.lzc.thinkingInJava.typeinfo.pets.Mouse",
            "com.lzc.thinkingInJava.typeinfo.pets.Hamster",
            "com.lzc.thinkingInJava.typeinfo.pets.Gerbil",
    };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for(String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static{
        loader();
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
