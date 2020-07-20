package com.lzc.thinkingInJava.strings;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner s = new Scanner("1, 2, 3, 4, 5");
        Pattern p = Pattern.compile("\\s*,\\s*",0);
        //s.useDelimiter("\\s*,\\s*");
        s.useDelimiter(p);
        while(s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
