package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.HashMap;
import java.util.Map;

public class E38_LoadFactor {
    private static void testGet(Map<String, String> filledMap, int n){
        for(int i = 0; i < 1000000; i++){
            for(int j = 0; j < Countries.DATA.length; j++){
                String key = Countries.DATA[j][0];
                filledMap.get(key);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.putAll(Countries.capitals(11));
        HashMap<String, String> map2 = new HashMap<String, String>(32);
        map2.putAll(Countries.capitals(11));
        long start1 = System.currentTimeMillis();
        testGet(map1, 11);
        long end1 = System.currentTimeMillis();
        System.out.println("Test map1:" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        testGet(map2, 11);
        long end2 = System.currentTimeMillis();
        System.out.println("Test map2:" + (end2 - start2));
    }
}
