package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Practice16 {
    public static void vowelCounter(Set<String> st){
        Set<Character> vowels = new TreeSet<Character>();
        Collections.addAll(vowels,
                'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int allVowels = 0;
        for(String s : st) {
            int count = 0;
            for(Character c : s.toCharArray()){
                if(vowels.contains(c)){
                    count++;
                    allVowels++;
                }
                System.out.print(s + ": " + count + ", ");
            }
        }
        System.out.println();
        System.out.print("Total vowels: " + allVowels);
    }
    public static void main(String[] args){
        Set<String> words = new TreeSet<String>(
                new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java", "\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
