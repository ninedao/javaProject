package com.lzc.thinkingInJava.generics;

import java.util.HashMap;
import java.util.Map;

public class E24_ClassTypeCapture {
    private Map<String, FactoryI1<?>> map = new HashMap<String, FactoryI1<?>>();
    public E24_ClassTypeCapture(){}
    public E24_ClassTypeCapture(String s, FactoryI1<?> c) {
        map.put(s, c);
    }
    public void addType(String s, FactoryI1<?> c) {
        map.put(s, c);
    }
    public Object createNew(String typename, int args) {
        FactoryI1<?> type = map.get(typename);
        try {
            return type.create(args);
        } catch (NullPointerException e) {
            System.out.println("Not a registered typename: " + typename);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public static void main(String[] args) {
        E24_ClassTypeCapture e21 = new E24_ClassTypeCapture();
        e21.addType("Integer", new IntegerFactory1());
        e21.addType("Widget1", new Widget1.Factory());
        System.out.println(e21.createNew("Integer", 1));
        System.out.println(e21.createNew("Widget1",1));
        e21.createNew("Product",2);
    }
}
