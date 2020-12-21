package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.OSExecute;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap /out/production/javaProject/com/lzc/thinkingInJava/io/OSExecuteDemo","GBK");
    }
}
