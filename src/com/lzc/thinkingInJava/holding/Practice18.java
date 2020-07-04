package com.lzc.thinkingInJava.holding;

import java.util.*;

public class Practice18 {
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
        System.out.println(map);
        Set<String> sortedKeys =
                new TreeSet<String>(map.keySet());
        System.out.println(sortedKeys);

        Map<String, Gerbil> sortedGerbils =
                new LinkedHashMap<String, Gerbil>();
        for(String s : sortedKeys) {
            System.out.print("Adding " + s + ", ");
            sortedGerbils.put(s, map.get(s));
        }
        System.out.println();
        System.out.println();
        System.out.println(sortedGerbils);
        System.out.println();
        // or, just:
        Map<String, Gerbil> sortedGerbils2 =
                new TreeMap<String, Gerbil>(map);
        System.out.println(sortedGerbils2);
    }
}
