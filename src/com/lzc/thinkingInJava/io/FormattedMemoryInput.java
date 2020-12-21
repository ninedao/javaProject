package com.lzc.thinkingInJava.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\E11_GreenHouseControls2.java").getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        }catch (EOFException e) {
            System.err.println("End of Stream");
        }
    }
}
