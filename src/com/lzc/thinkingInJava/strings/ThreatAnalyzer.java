package com.lzc.thinkingInJava.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {
    static String threatData = "58.27.82.161@02/10/2005\n" +
            "204.45.234.40@02/11/2005\n" +
            "58.27.82.161@02/11/2005\n" +
            "58.27.82.161@02/11/2005\n" +
            "58.27.82.161@02/11/2005\n" +
            "[Next log section with different data format]";
    public static void main(String[] args) {
        Scanner sc = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
        while(sc.hasNext(pattern)) {
            System.out.println(sc.next(pattern));
            MatchResult match = sc.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }

}
