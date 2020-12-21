package com.lzc.thinkingInJava.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endians {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[12]);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        System.out.println(Arrays.toString(byteBuffer.array()));
        byteBuffer.rewind();
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(Arrays.toString(byteBuffer.array()));
        byteBuffer.rewind();
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));
    }
}
