package com.lzc.thinkingInJava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E08_CommandLine {
    public static void main(String[] args) throws IOException {
        args = new String[]{"C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java"};
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for(ListIterator it = list.listIterator(list.size());it.hasPrevious();){
            System.out.println(it.previous());
        }
    }
}
