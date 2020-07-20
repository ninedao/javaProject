package com.lzc.thinkingInJava.strings;

import java.util.Arrays;

public class Practice9 {
    public static void main(String[] args){
        String s = Splitting.knights;
        System.out.println(s.replaceAll("[aeiouAEIOU]","_"));
    }
}
