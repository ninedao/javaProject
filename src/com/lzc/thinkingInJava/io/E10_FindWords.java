package com.lzc.thinkingInJava.io;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class E10_FindWords {
    public static void main(String[] args) throws IOException {
        args = new String[]{"C:\\LocalFiles\\project\\IdeaProjects\\" +
                "javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java", "c","a"};
        if(args.length < 2){
            throw new IllegalArgumentException();
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        Set<String> words = new HashSet<String>();
        for(int i = 1; i < args.length; i++){
            words.add(args[i]);
        }
        for(ListIterator<String> it = list.listIterator(list.size());it.hasPrevious();){
            String s = it.previous();
            for(String str : words){
                if(s.contains(str)){
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}
