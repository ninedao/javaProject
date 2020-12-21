package com.lzc.thinkingInJava.io.xfiles;

import java.io.*;

public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\X.file")));
        Object mystery = objectInputStream.readObject();
        System.out.println(mystery.getClass());
    }
}
