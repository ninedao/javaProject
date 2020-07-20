package com.lzc.thinkingInJava.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Practice14 {
    public static void main(String[] args) {
        String input = "This!!unusual use!!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        System.out.println(Arrays.toString(input.split("!!",3)));
    }
}
