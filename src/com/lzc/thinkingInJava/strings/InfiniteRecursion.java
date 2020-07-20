package com.lzc.thinkingInJava.strings;

import java.util.ArrayList;
import java.util.List;
/*
* 结果是异常
* */
public class InfiniteRecursion {
    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
    }
    public static void main(String[] args){
        List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
        for(int i = 0; i < 10; i++) {
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
