package com.lzc.thinkingInJava.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().lock();
        if(fl != null){
            System.out.println("Locked File " + fl.isShared()+" " + fl.isValid());
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Release File " + fl.isShared()+" " + fl.isValid());
        }
        fos.close();


    }
}
