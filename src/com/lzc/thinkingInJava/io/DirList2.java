package com.lzc.thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args) {
        args = new String[]{"E.*\\.java"};
        File file = new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers");
        String[] list;
        if(args.length == 0){
            list = file.list();
        }else{
            list = file.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
