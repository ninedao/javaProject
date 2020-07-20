package com.lzc.thinkingInJava.strings;

import java.util.Arrays;

public class Practice8 {
    public static void main(String[] args){
        String s = Splitting.knights;
        System.out.println(Arrays.toString(s.split("the|you")));
    }
}
