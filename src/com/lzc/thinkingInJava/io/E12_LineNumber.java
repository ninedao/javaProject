package com.lzc.thinkingInJava.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

public class E12_LineNumber {
    public static void main(String[] args) throws IOException {
        args = new String[]{"C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java"};
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        PrintWriter printWriter = new PrintWriter("E12_LineNumber.out");
        int i = list.size();
        for(ListIterator it = list.listIterator(list.size());it.hasPrevious();){
            printWriter.println(i-- + ": " + it.previous());
        }
        printWriter.close();
        System.out.println(BufferedInputFile.read("E12_LineNumber.out"));
    }
}
