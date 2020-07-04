package com.lzc.thinkingInJava.holding;

import java.util.*;

public class Practice19 {
    public static void main(String[] args){
        Map<String, Gerbil> map = new HashMap<String, Gerbil>();
        map.put("Fuzzy", new Gerbil());
        map.put("Spot", new Gerbil());
        map.put("Speedy", new Gerbil());
        map.put("Dopey", new Gerbil());
        map.put("Sleepy", new Gerbil());
        map.put("Happy", new Gerbil());
        map.put("Funny", new Gerbil());
        map.put("Silly", new Gerbil());
        map.put("Goofy", new Gerbil());
        map.put("Wowee", new Gerbil());
        System.out.println(map.keySet());
        System.out.println(map);
        Set<String> keySets = new HashSet<String>(map.keySet());
        System.out.println(keySets);
        Map<String, Gerbil> keySetMap = new LinkedHashMap<String, Gerbil>();
        for(String e : keySets){
            keySetMap.put(e, map.get(e));
        }
        System.out.println(keySetMap);

        Set<String> keyLinkedSets = new LinkedHashSet<String>(map.keySet());
        System.out.println(keyLinkedSets);
        Map<String, Gerbil> keyLinkedMap = new LinkedHashMap<String, Gerbil>();
        for(String e : keyLinkedSets){
            keyLinkedMap.put(e, map.get(e));
        }
        System.out.println(keyLinkedMap);

    }
}
