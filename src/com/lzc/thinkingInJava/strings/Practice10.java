package com.lzc.thinkingInJava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lzc.thinkingInJava.util.Print.print;

public class Practice10 {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        args = new String[]{"Java now has regular expressions", "^Java", "\\breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s{4}", "s{1}.", "s{0,3}"};
        if(args.length < 2) {
            print("Usage:\njava TestRegularExpression " +
                    "characterSequence regularExpression+");
            System.exit(0);
        }
        print("Input: \"" + args[0] + "\"");
        for(String arg : args) {
            print("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            if(!m.find())
                print("No match found for " + "\"" + arg + "\"");
            m.reset();
            while(m.find()) {
                print("Match \"" + m.group() + "\" at position " +
                        m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
            }
        }
    }
}
