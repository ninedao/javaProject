package com.lzc.thinkingInJava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice11 {
    static String reg = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
    static String str = "Arline ate eight apples and one oranges while Anita Hadn't any.";
    public static void main(String[] args){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while(m.find()) {
            System.out.println(m.group() + " in: " + m.start() + "-" +(m.end() - 1));
        }
    }
}