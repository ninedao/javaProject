package com.lzc.thinkingInJava.generics;

import java.util.HashMap;
import java.util.Map;

public class E21_ClassTypeCapture2 {
    private Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    public E21_ClassTypeCapture2(){}
    public E21_ClassTypeCapture2(String s, Class<?> c) {
        map.put(s, c);
    }
    public void addType(String s, Class<?> c) {
        map.put(s, c);
    }
    public Object createNew(String typename) {
        Class<?> type = map.get(typename);
        try {
            return type.newInstance();
        } catch (NullPointerException e) {
            System.out.println("Not a registered typename: " + typename);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public static void main(String[] args) {
        E21_ClassTypeCapture2 e21 = new E21_ClassTypeCapture2();
        e21.addType("Building", Building.class);
        e21.addType("House", House.class);
        e21.addType("Product", Product.class);
        System.out.println(e21.createNew("Building").getClass());
        System.out.println(e21.createNew("House").getClass());
        e21.createNew("Product");
        e21.createNew("Car");
    }
}
