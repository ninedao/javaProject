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
public class Practice19 {
    public static void main(String[] args){
        // we want all class names:
        Pattern p = Pattern.compile("class \\w+\\s+");
        // not including those in comment lines:
        Pattern q = Pattern.compile("^(//|/\\*|\\*)");
        //System.out.println("classes in " + args[0] + ":");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        Matcher n = q.matcher("");
        for(String line : new TextFile("src/com/lzc/thinkingInJava/strings/Practice19.java")) {
            m.reset(line);
            n.reset(line);
            while(m.find() && !n.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}
