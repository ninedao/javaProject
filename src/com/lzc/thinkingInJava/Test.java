package com.lzc.thinkingInJava;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Test {
    static void storyReader (InputStream in, int lineSize,String ... bookmark) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
        String str = null;
        int i = 0;
        boolean bookmarkB = false;
        if(bookmark != null){
            bookmarkB = true;
        }
        while((str = br.readLine() ) != null ){
            if(str.indexOf(bookmark[0]) > 0){
                bookmarkB = false;
            }
            if(str.length() == 0 || bookmarkB){
                continue;
            }
            readLine(str, 100);
            i++;
            if(i >= lineSize){
                Scanner scl = new Scanner(System.in);
                while(scl.hasNext()) {
                    String flag = scl.next();
                    if(flag.equals("'")){
                        i = 0;
                        break;
                    }else{
                        continue;
                    }
                }
            }
            //Thread.sleep(3000);
        }
    }
    static void readLine(String line, int size) {
        int length = (line.length() / size) +1;
        for(int i = 0; i < length; i ++){
            System.out.println(line.substring(i * size, ((i+1) * size > line.length() ? line.length() : (i + 1) * size)));
        }
    }
    public static void main(String[] args) {
        int chapter = 587325277;
        try {
            storyReader(new FileInputStream(new File("C:\\Users\\11197\\Downloads\\41313.txt")), 50, "白蒙蒙的大雾之中");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
