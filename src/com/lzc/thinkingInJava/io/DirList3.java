package com.lzc.thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    private static final String[] arg = new String[]{"E.*\\.java"};
    public static void main(final String[] args) {
        File file = new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers");
        String[] list;
        if(arg.length == 0){
            list = file.list();
        }else{
            list = file.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(arg[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
