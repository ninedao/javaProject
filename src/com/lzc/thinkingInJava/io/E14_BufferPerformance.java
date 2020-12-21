package com.lzc.thinkingInJava.io;

import java.io.*;
import java.util.List;

public class E14_BufferPerformance {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        List<String> list = E07_FileIntoList.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\BasicFileOutput.java");
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        int lineCount = 1;
        long time1 = System.currentTimeMillis();
        for(String s : list){
            for(int i = 0; i < 10000; i++){
                pw.println(lineCount + ": " +s);
            }
            lineCount++;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("unbuffered: " + (time2 - time1));
        pw.close();

        pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        lineCount = 1;
        long time3 = System.currentTimeMillis();
        for(String s : list){
            for(int i = 0; i < 10000; i++){
                pw.println(lineCount + ": " +s);
            }
            lineCount++;
        }
        long time4 = System.currentTimeMillis();
        System.out.println("buffered: " + (time4 - time3));
        pw.close();
    }
}
