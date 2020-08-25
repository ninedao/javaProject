package com.lzc.thinkingInJava.generics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;
    static void asign1(List list){
        list1 = list;
        list2 = list;
        // warning未经检验的转换
        //list3 = list;
    }
    static void asign2(List<?> list){
        list1 = list;
        list2 = list;
        list3 = list;
    }
    static void asign3(List<? extends  Object> list){
        list1 = list;
        list2 = list;
        list3 = list;
    }
    public static void main(String[] args) {
        asign1(new ArrayList());
        asign2(new ArrayList());
        // warning未经检验的转换
        //asign3(new ArrayList());

        asign1(new ArrayList<String>());
        asign2(new ArrayList<String>());
        asign3(new ArrayList<String>());

        List<?> wildList = new ArrayList<>();
        wildList = new ArrayList<String>();
        asign1(wildList);
        asign2(wildList);
        asign3(wildList);
    }
}
