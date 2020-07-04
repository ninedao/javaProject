package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.*;

public class Practice25 {
    public static void main(String[] args){

        Map<String, ArrayList<Integer>> map = new LinkedHashMap<String, ArrayList<Integer>>();
        List<String> list = new ArrayList<>(new TextFile("src/com/lzc/thinkingInJava/holding/SetOperations.java","\\W+"));
        for(int i = 0; i < list.size(); i++ ){
            String ele = list.get(i);
            ArrayList<Integer> aList = map.get(ele);
            if(aList == null){
                ArrayList<Integer> aaList = new ArrayList<Integer>();
                aaList.add(i);
                map.put(ele, aaList);
            }else{
                aList.add(i);
                map.put(ele, aList);
            }
        }
        System.out.println(map);
    }
}
