package com.lzc.thinkingInJava.strings;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src/com/lzc/thinkingInJava/strings/TheReplacements.java");
        Matcher m = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if(m.find()) {
            s = m.group(1);
        }
        s = s.replaceAll(" {2,}"," ");
        //System.out.println(s);
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "[VOWEL1]");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher mm = p.matcher(s);
        while(mm.find()) {
            mm.appendReplacement(sbuf, mm.group().toUpperCase());
            //mm.appendReplacement(sbuf, "$0");
        }
        mm.appendTail(sbuf);
        System.out.println(sbuf);

    }

}
