package com.lzc.thinkingInJava.io;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\E11_GreenHouseControls2.java")));
        while(in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }
}
