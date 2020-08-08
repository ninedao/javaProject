package com.lzc.thinkingInJava.typeinfo;

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftclass = FancyToy.class;
        FancyToy f = ftclass.newInstance();
        Class<? super FancyToy> up = ftclass.getSuperclass();
        //Class<Toy> m = ftclass.getSuperclass();
        Object obj = up.newInstance();
        System.out.println(obj.getClass().getCanonicalName());
    }
}
