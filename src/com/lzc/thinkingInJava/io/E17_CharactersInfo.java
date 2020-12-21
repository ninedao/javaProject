package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.HashMap;
import java.util.Map;

public class E17_CharactersInfo {
    public static void main(String[] args) {
        String s = TextFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\util\\TextFile.java");
        char[] strings = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : strings){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c) + 1);
            }
        }
        System.out.println(map);
    }
}
