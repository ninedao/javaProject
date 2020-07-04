package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.*;

public class Practice20 {
    public static void vowelCounter(Set<String> st){
        Map<Character, Integer> vowels = new HashMap<Character, Integer>();
        vowels.put('A', 0);
        vowels.put('E', 0);
        vowels.put('I', 0);
        vowels.put('O', 0);
        vowels.put('U', 0);
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        int allVowels = 0;
        for(String s : st) {
            int count = 0;
            for(Character c : s.toCharArray()){
                if(vowels.keySet().contains(c)){
                    vowels.put(c, 1 + vowels.get(c));
                    count++;
                    allVowels++;
                }
                System.out.print(s + ": " + count + ", ");
            }
        }
        System.out.println();
        System.out.print("Total vowels: " + allVowels);
        System.out.println(vowels);
    }
    public static void main(String[] args){
        Set<String> words = new TreeSet<String>(
                new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java", "\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
