package com.lzc.thinkingInJava.holding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ForEachCollections {
    public static void main(String[] args){
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for(String e : cs){
            System.out.print("'" + e + "' ");
        }
    }
}
