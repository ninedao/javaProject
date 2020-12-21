package com.lzc.thinkingInJava.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

import static com.lzc.thinkingInJava.util.Print.print;

public class ZipCompress {
    public static void main(String[] args) throws IOException {
        args = new String[]{"io_Redirecting.out"};
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f,new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        for(String arg : args){
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            // 往zip内添加目录节点
            zos.putNextEntry(new ZipEntry(arg));
            // 往节点内写入内容
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();

        System.out.println("Checksum: " + csum.getChecksum().getValue());
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);

        ZipEntry ze;
        while((ze = in2.getNextEntry()) != null){
            System.out.println("Reading file " + ze);
            int x;
            while((x = bis.read()) != -1){
                System.out.write(x);
            }
        }

        if(args.length == 1) {
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();

        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();

        ZipEntry ze2 = null;
        while(e.hasMoreElements()){
            ze2 = (ZipEntry) e.nextElement();

            System.out.println("File:" + ze2);

        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zf.getInputStream(ze2))) ;
        String s;
        while((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
    }
}
