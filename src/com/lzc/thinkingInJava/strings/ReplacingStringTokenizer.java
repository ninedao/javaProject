package com.lzc.thinkingInJava.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String s = "But I'm not dead yet! I feel happy";
        StringTokenizer stoke = new StringTokenizer(s);
        while(stoke.hasMoreElements()) {
            System.out.print(stoke.nextToken() + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(s.split(" ")));
        Scanner sc = new Scanner(s);
        while(sc.hasNext()) {
            System.out.print(sc.next() + " ");
        }
    }
}
