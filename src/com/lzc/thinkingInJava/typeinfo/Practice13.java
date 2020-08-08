package com.lzc.thinkingInJava.typeinfo;


import com.lzc.thinkingInJava.generics.coffee.Coffee;

public class Practice13 {

    public static void main(String[] args){
        TypeCounter t = new TypeCounter(Part.class);
        Part part;
        for(int i = 0; i < 20; i++) {
            part = Part.createRandom();
            System.out.print(part.getClass().getSimpleName() + " ");
            t.count(part);
        }
        System.out.println();
        System.out.println(t.toString());
    }
}
