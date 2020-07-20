package com.lzc.thinkingInJava.strings;


import com.lzc.thinkingInJava.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// strings/Practice17.java
// TIJ4 Chapter Strings, Exercise 17, page 546
/* Write a program that reads a Java source-code file (you provide the
* file name on the command line) and displays all the comments.
*/
// {Args: fileName}
public class Practice18 {
    public static void main(String[] args){
        Pattern p = Pattern.compile("\".*\"");
        // Iterate through the lines of the input file:
        Matcher m = p.matcher("src/com/lzc/thinkingInJava/strings/Practice18.java");
        for(String line : new TextFile("src/com/lzc/thinkingInJava/strings/Practice18.java")) {
            m.reset(line);
            while (m.find()) {

                System.out.println(m.group());
            }
        }
    }
}
