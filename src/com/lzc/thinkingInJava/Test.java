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
        while((str = br.readLine() ) != null && i < lineSize){
            if(str.indexOf(bookmark[0]) > 0){
                bookmarkB = false;
            }
            if(str.length() == 0 || bookmarkB){
                continue;
            }
            readLine(str, 90);
            i++;
            if(i >= lineSize){
                Scanner scl = new Scanner(System.in);
                while(scl.hasNext()) {
                    int flag = scl.nextInt();
                    if(flag == 0){
                        i = 0;
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
    }
    static void readLine(String line, int size) {
        int length = (line.length() / size) +1;
        for(int i = 0; i < length; i ++){
            System.out.println(line.substring(i * size, ((i+1) * size > line.length() ? line.length() : (i + 1) * size)));
        }
    }
    public static void main(String[] args) throws Exception {
        int chapter = 587325277;
        //https://wap.dzxsw.net/book/111110/6263594_2.html

//        do{
//
//            //URL url = new URL("https://www.lvsetxt.com/books/25185/25185637/"+chapter+".html");
//
//            //InputStream is = url.openConnection().getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\11197\\Downloads\\40682.txt")),"GBK"));
//            StringBuffer sb = new StringBuffer();
//            String str = br.readLine();
//            while (str!= null) {
//                //str.replaceAll("[^\\u4e00-\\u9fa5]*","");
//
//                //str.replaceAll("D","");
//                sb.append(str);
//                str = br.readLine();
//            }
//            Scanner sc = new Scanner(System.in);
//            System.out.println(sb.toString().replaceAll("<br/>","\n").replaceAll("[^\\u4e00-\\u9fa5,1-9\\n]",""));
//            sc = new Scanner(System.in);
//        }while(sc.nextInt() == 0);

        storyReader(new FileInputStream(new File("C:\\Users\\11197\\Downloads\\40682.txt")), 100, "寻找杨间的踪迹");
    }
}
