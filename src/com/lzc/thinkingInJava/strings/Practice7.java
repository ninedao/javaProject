package com.lzc.thinkingInJava.strings;

import static com.lzc.thinkingInJava.util.Print.print;

public class Practice7 {
    public static void main(String[] args){
        String sen = "^[A-Z].*[\\.]$";
        String s1 = "Once upon a time.";
        String s2 = "abcd.";
        String s3 = "Abcd?";
        String s4 = "An easy way out.";
        String s5 = "Zorro.";
        String s6 = "X.";
        print(s1.matches(sen));
        print(s2.matches(sen));
        print(s3.matches(sen));
        print(s4.matches(sen));
        print(s5.matches(sen));
        print(s6.matches(sen));
    }
}
