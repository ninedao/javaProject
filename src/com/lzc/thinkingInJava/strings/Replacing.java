package com.lzc.thinkingInJava.strings;

public class Replacing {
    public static void main(String[] args){
        String s = Splitting.knights;
        System.out.println(s.replaceFirst("f\\w+", "located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
