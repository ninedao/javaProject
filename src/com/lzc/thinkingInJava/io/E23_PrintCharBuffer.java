package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.generics.ByteSet;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

public class E23_PrintCharBuffer {
    static BitSet bitSet = new BitSet(127);
    static String encoding = System.getProperty("file.encoding");
    static {
        for(int i = 37; i <=127; i++){
            bitSet.set(i);
        }
    }
    //使字符限制在127以下，charBuffer的上限设为取不到的那个字符
    public static void setPrintableLimit(CharBuffer charBuffer){
        charBuffer.rewind();
        while(bitSet.get(charBuffer.get()));
        charBuffer.limit(charBuffer.position() - 1);
        charBuffer.rewind();
    }
    public static void main(String[] args) {
        System.out.println("Default Encoding is " + encoding);
        CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
        buffer.put("ABCDE" + (char)0x01 + "FG");
        buffer.rewind();
        System.out.println(buffer);
        setPrintableLimit(buffer);
        System.out.println(buffer);
    }
}
