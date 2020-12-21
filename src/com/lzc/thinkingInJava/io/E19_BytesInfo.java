package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.BinaryFile;
import com.lzc.thinkingInJava.util.TextFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class E19_BytesInfo {
    public static void main(String[] args) throws IOException {
        byte[] s = BinaryFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\util\\TextFile.java");
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        for(byte c : s){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c) + 1);
            }
        }
        System.out.println(map);
    }
}
