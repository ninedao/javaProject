package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static com.lzc.thinkingInJava.util.Countries.capitals;
import static com.lzc.thinkingInJava.util.Countries.names;

public class E02_ACountries {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<String, String>(capitals());
        TreeSet<String> set = new TreeSet<String>(names());
        String b = null;
        for(String s : map.keySet()){
            if(s.startsWith("B")){
                b = s;
                break;
            }
        }
        Map<String, String> map1 = map.headMap(b);
        Set<String> set1 = set.headSet(b);
        System.out.println(map1);
        System.out.println(set1);
        System.out.println(Float.floatToIntBits(2.2f));

    }
}
