package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.BinaryFile;
import com.lzc.thinkingInJava.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// class以十六进制CAFEBABE开头，
public class E20_ClassSignatureChecker {
    public static void main(String[] args) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\out",".*class$");
        byte[] bytes = null;
        for(File file : treeInfo.files){
            bytes = BinaryFile.read(file);
            System.out.print(file.getName() + "' is ");
            for(int i = 0; i < 8; i++){
                System.out.print(bytes[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println((byte)202);
        System.out.println((byte)254);
        System.out.println((byte)186);
        System.out.println((byte)190);
    }
}
