package com.lzc.thinkingInJava.holding;

import java.util.*;

import static com.lzc.thinkingInJava.util.Print.*;
public class PrintingContainers {
    static Collection fill(Collection<String> c){
        c.add("rat");
        c.add("cat");
        c.add("dog");
        c.add("dog");
        return c;
    }
    static Map fill(Map<String,String> c){
        c.put("rat", "Fuzzy");
        c.put("cat", "Rags");
        c.put("dog", "Bosco");
        c.put("dog", "Spot");
        return c;
    }
    public static void main(String[] args){
        print(fill(new ArrayList<>()));
        print(fill(new LinkedList<>()));
        print(fill(new HashSet<>()));
        print(fill(new TreeSet<>()));
        print(fill(new LinkedHashSet<>()));

        print(fill(new HashMap<>()));
        print(fill(new TreeMap<>()));
        print(fill(new LinkedHashMap<>()));
    }
}
