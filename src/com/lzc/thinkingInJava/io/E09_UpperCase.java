package com.lzc.thinkingInJava.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class E09_UpperCase {

    public static void main(String[] args) throws IOException {

        args = new String[]{"C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java"};
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<String>(E07_FileIntoList.read(args[0]));
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            System.out.println(it.previous().toUpperCase());
        }
    }
}
