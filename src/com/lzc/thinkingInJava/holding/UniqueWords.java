package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.Set;
import java.util.TreeSet;
public class UniqueWords {
    public static void main(String[] args){
        Set<String> set = new TreeSet<String>(new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java","\\W+"));
        System.out.println(set);
    }
}
