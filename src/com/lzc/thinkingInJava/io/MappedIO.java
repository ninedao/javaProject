package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.containers.Test;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 20000;
    private abstract static class Tester {
        private String name;
        public Tester(String name) {
            this.name = name;
        }
        public void runTest(){
            System.out.print(name + ": ");
            try{
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        public abstract void test() throws IOException;
    }
    private static Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
                    for(int i = 0; i < numOfInts; i++ ){
                        stream.writeInt(i);
                    }
                    stream.close();
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp","rw").getChannel();
                    IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
                    for(int i = 0; i < numOfInts; i++ ){
                        intBuffer.put(i);
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                    for(int i = 0; i < numOfInts; i++) {
                        dataInputStream.readInt();
                    }
                    dataInputStream.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp","r").getChannel();
                    IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size()).asIntBuffer();
                    while(intBuffer.hasRemaining()) {
                        intBuffer.get();
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("temp.tmp","rw");
                    randomAccessFile.write(1);
                    for(int i = 0; i < numOfUbuffInts; i++) {
                        randomAccessFile.seek(randomAccessFile.length() - 4);
                        randomAccessFile.writeInt(randomAccessFile.readInt());
                    }
                    randomAccessFile.close();
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile("temp.tmp","rw").getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size()).asIntBuffer();
                    intBuffer.put(0);
                    for(int i = 1; i < numOfUbuffInts; i++) {
                        intBuffer.put(intBuffer.get(i - 1));
                    }
                    fileChannel.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester tester : tests) {
            tester.runTest();
        }
    }
}
