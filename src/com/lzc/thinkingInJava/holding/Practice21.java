package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.*;

public class Practice21 {
    public static void main(String[] args){
        List<String> set = new ArrayList<String>(new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java","\\W+"));
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        Collections.sort(set, String.CASE_INSENSITIVE_ORDER);
        for(String e : set){
            if (map.get(e) == null) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }
        System.out.println(map);
    }
}
