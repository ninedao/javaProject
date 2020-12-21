package com.lzc.thinkingInJava.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        buffer.rewind();
        FloatBuffer floatBuffer = buffer.asFloatBuffer();
        while(floatBuffer.hasRemaining()){
            System.out.println(floatBuffer.get());
        }
        buffer.rewind();
        DoubleBuffer doubleBuffer = buffer.asDoubleBuffer();
        while(doubleBuffer.hasRemaining()){
            System.out.println(doubleBuffer.get());
        }
        System.out.println((long)1.36E-43);
        for(byte b : new byte[]{0,0,0,0,0,0,0,'a'}){
            System.out.print(Integer.toBinaryString(b));
        }

    }
}
