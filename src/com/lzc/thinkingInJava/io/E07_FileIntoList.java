package com.lzc.thinkingInJava.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class E07_FileIntoList {
    public static List<String> read(String path) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(path));
        LinkedList<String> sb = new LinkedList<String>();
        String s;
        while((s = bf.readLine()) != null) {
            sb.add(s);
        }
        bf.close();
        return sb;
    }
    public static void main(String[] args) throws IOException {

        List<String> list = read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java");
        //Collections.reverse(sb);
        for(ListIterator it = list.listIterator(list.size());it.hasPrevious(); ){
            System.out.println(it.previous());
        }
    }
}
