package com.lzc.thinkingInJava.strings;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice15 {
    public static void main(String[] args){
        args = new String[]{"src/com/lzc/thinkingInJava/strings/JGrep.java","\\b[Ssct]\\w+",String.valueOf(Pattern.CASE_INSENSITIVE)};
        if(args.length > 3) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1],Integer.valueOf(args[2]));
        int i = 0;
        Matcher m = p.matcher("");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()) {
                System.out.println(i ++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}
