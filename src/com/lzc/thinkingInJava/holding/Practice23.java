package com.lzc.thinkingInJava.holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Practice23 {
    public static void main(String[] args){
        Random rand = new Random(47);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = map.get(r);
            map.put(r,freq == null ? 1 : freq + 1);
        }
        int max = 0;
        for(Integer e : map.keySet()){
            if(map.get(e) > max){
                max = e;
            }
        }
        System.out.println(map);
        System.out.println(max);
    }
}
