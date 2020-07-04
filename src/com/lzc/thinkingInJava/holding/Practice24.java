package com.lzc.thinkingInJava.holding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Practice24 {
    public static void main(String[] args){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("ten", 10);
        map.put("nine", 9);
        map.put("eight", 8);
        map.put("seven", 7);
        map.put("six", 6);
        map.put("five", 5);
        map.put("four", 4);
        map.put("three", 3);
        map.put("two", 2);
        map.put("one", 1);
        map.put("zero", 0);
        System.out.println("Map to sort: " + map);
        Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();
        Set<String> set = new TreeSet<String>(map.keySet());
        for(String e : set){
            Integer i = map.get(e);
            map.remove(e);
            map1.put(e, i);
        }
        System.out.println(map1);
        set = new TreeSet<String>(map1.keySet());
        for(String e : set){
            Integer i = map1.get(e);
            map1.remove(e);
            map.put(e, i);
        }
        System.out.println(map);
    }
}
