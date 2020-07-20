package com.lzc.thinkingInJava.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Hex {
    public static String format(byte[] data){
        StringBuffer result = new StringBuffer();
        int n = 0;
        for(byte b : data) {
            if(n % 16 == 0) {
                result.append(String.format("%05x: ", n));
            }
            result.append(String.format("%02x ", b));
            n++;
            if(n % 16 == 0){
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                new File("src/com/lzc/thinkingInJava/util/Hex.java").getAbsoluteFile()));
        byte[] data = new byte[in.available()];
        in.read(data);
        in.close();
        System.out.println(format(data));
    }
}
