package com.lzc.thinkingInJava.io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        System.out.println(1);
        PrintStream printStream = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\util\\TextFile.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("io_Redirecting.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        while((s = br.readLine()) != null) {
            System.err.println(s);
        }
        out.close();
        System.out.println(printStream);
    }
}
