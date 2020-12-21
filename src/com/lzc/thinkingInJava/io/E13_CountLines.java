package com.lzc.thinkingInJava.io;

import java.io.*;

public class E13_CountLines {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        LineNumberReader br = new LineNumberReader(new StringReader(BufferedInputFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\BasicFileOutput.java")));
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        String s;
        //int lineCount = 1;
        while((s = br.readLine()) != null){
            pw.println(br.getLineNumber() + ": " + s);
        }
        pw.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
