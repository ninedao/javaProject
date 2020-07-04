package com.lzc.thinkingInJava.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Practice17 {
    public static void main(String[] args){
        Map<String, Gerbil> map = new HashMap<String, Gerbil>();
        map.put("Fuzzy", new Gerbil());
        map.put("Spot", new Gerbil());
        map.put("Speedy", new Gerbil());
        map.put("Dopey", new Gerbil());
        map.put("Sleepy", new Gerbil());
        map.put("Happy", new Gerbil());
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            map.get(it.next()).hop();
        }
    }
}
