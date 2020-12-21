package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.TextFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E25_JGrep {
    public static void main(String[] args) throws IOException {
        args = new String[]{"src/com/lzc/thinkingInJava/strings/JGrep.java","\\b[Ssct]\\w+"};
        if(args.length > 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        int i = 0;
        Matcher m = p.matcher("");
        FileChannel fileChannel = new RandomAccessFile(args[0],"r").getChannel();
        ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0, fileChannel.size());
        CharBuffer charBuffer = Charset.forName(System.getProperty("file.encoding")).decode(byteBuffer);
        String[] strings = charBuffer.toString().split("\n");
        for(String line : strings) {
            m.reset(line);
            while(m.find()) {
                System.out.println(i ++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}
