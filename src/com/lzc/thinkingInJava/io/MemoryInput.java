package com.lzc.thinkingInJava.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\E11_GreenHouseControls2.java"));
        int c;
        while((c = stringReader.read()) != -1){
            System.out.print((char)c);
        }
    }
}
