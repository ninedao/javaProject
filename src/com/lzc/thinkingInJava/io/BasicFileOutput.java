package com.lzc.thinkingInJava.io;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(BufferedInputFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\BasicFileOutput.java")));
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        String s;
        int lineCount = 1;
        while((s = br.readLine()) != null){
            pw.println(lineCount++ + ": " + s);
        }
        pw.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
