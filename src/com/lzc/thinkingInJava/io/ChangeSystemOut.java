package com.lzc.thinkingInJava.io;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        // boolean为true设置为自动刷新
        PrintWriter printWriter = new PrintWriter(System.err, true);
        printWriter.println("Hello, World");
    }
}
