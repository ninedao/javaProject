package com.lzc.thinkingInJava;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        int chapter = 587325277;
        //https://wap.dzxsw.net/book/111110/6263594_2.html
        Scanner sc = new Scanner(System.in);
        do{

            URL url = new URL("https://www.lvsetxt.com/books/25185/25185637/"+chapter+".html");

            InputStream is = url.openConnection().getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
            StringBuffer sb = new StringBuffer();
            String str = br.readLine();
            while (str!= null) {
                //str.replaceAll("[^\\u4e00-\\u9fa5]*","");

                //str.replaceAll("D","");
                sb.append(str);
                str = br.readLine();
            }

            System.out.println(sb.toString().replaceAll("<br/>","\n").replaceAll("[^\\u4e00-\\u9fa5,1-9\\n]",""));
            sc = new Scanner(System.in);
        }while(sc.nextInt() == 0);

    }
}
