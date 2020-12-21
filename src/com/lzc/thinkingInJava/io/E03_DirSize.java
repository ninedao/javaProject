package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
// E.*.java
public class E03_DirSize {
    public static void main(String[] args) {
        File file = new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers");
        String[] list;
        if(args.length == 0) {
            list = file.list();
        }else{
            list = file.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        long total = 0;
        long fs = 0;
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String item : list){
            fs = new File(file, item).length();
            System.out.println(item + ", " + fs + " byte(s)");
            total += fs;
        }
        System.out.println("====================");
        System.out.println(list.length + " file(s), " + total + " bytes");
    }
}
