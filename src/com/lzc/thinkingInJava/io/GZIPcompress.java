package com.lzc.thinkingInJava.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        args = new String[]{"test.dat"};
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));

        System.out.println("Writing file");
        int c;
        while((c = in.read()) != -1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Read file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        int s;
        while((s = in2.read()) != -1){
            System.out.print((char)s);
        }
    }
}
