package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.List;



public class E15_WordCounter {
    public static void main(String[] args) {
        List<String> list = new TextFile("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers\\E13_WordCounter.java","\\W+");
        SlowMap<String, Integer> associativeArray = new SlowMap<String, Integer>();
        for(String s : list){
            Integer count = associativeArray.get(s);
            associativeArray.put(s, count == null ? 1 : count + 1);
        }
        System.out.println(associativeArray.toString());
    }
}
