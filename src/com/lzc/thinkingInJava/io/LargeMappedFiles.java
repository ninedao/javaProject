package com.lzc.thinkingInJava.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF;
    public static void main(String[] args) throws IOException {
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("test.dat","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);
        for(int i = 0; i < length; i++){
            mappedByteBuffer.put((byte)'x');
        }
        for(int i = length / 2; i < length / 2 +6; i++){
            System.out.println((char)mappedByteBuffer.get(i));
        }
    }
}
