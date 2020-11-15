package com.lzc.thinkingInJava.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class E12_AssociativeArray<K, V> {
    private static void test(Map map){
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        try{
            map.put("extra", "object");
        }catch(Exception e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String,String>(6);
        test(hashMap);
        TreeMap<String,String> treeMap = new TreeMap<String,String>();
        test(treeMap);
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>(6);
        test(linkedHashMap);
    }
}
