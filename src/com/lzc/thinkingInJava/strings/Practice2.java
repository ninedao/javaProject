package com.lzc.thinkingInJava.strings;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }
    public static void main(String[] args){
        List<Practice2> list = new ArrayList<Practice2>();
        for(int i = 0; i < 10; i++) {
            list.add(new Practice2());
        }
        System.out.println(list);
        String s = "lzc";
        String mm = "zm";
        StringBuffer m = new StringBuffer().append("lzch");
        System.out.println(s.intern());
    }
}
