package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.*;
class Word{
    static int totalWords = 0;
    String s;
    int count;
    Word(String s, int count) {
        this.s = s;
        this.count = count;
        totalWords++;
    }
    public String toString() { return s + ": " + count; }
}
public class Practice22 {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>(new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java","\\W+"));
        Set<Word> map = new HashSet<Word>();
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String e : list){
            int count = 0;
            for(String i : list){
                if(e.equals(i)){
                    count++;
                }
            }
            Word word = new Word(e, count);
            map.add(word);
        }
        System.out.println(map);
    }
}
