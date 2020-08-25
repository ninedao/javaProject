package com.lzc.thinkingInJava.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnboundedWildcards2 {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;
    static void asign1(Map map){
        map1 = map;
    }
    static void asign2(Map<?, ?> map){
        map2 = map;
    }
    static void asign3(Map<String, ?> map){
        map3 = map;
    }
    public static void main(String[] args) {
        asign1(new HashMap());
        asign2(new HashMap());
        // warning未经检验的转换
        //asign3(new HashMap());
        asign1(new HashMap<String, Integer>());
        asign2(new HashMap<String, Integer>());
        asign3(new HashMap<String, Integer>());

    }
}
