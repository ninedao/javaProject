package com.lzc.thinkingInJava.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws IOException {
        args = new String[]{
                "C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\E12_LineNumber.out",
                "C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\io_Redirecting.out"
        };
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0,in.size(), out);

    }
}
