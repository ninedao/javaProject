package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E01_SearchWords {
    public static void main(final String[] args) {
        File file = new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers");
        String[] list;
        if(args.length == 0) {
            list = file.list();
        }else{
            list = file.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase();
                @Override
                public boolean accept(File dir, String name) {
                    System.out.println(dir);
                    if(name.toLowerCase().endsWith(ext)){
                        if(args.length == 1){
                            return true;
                        }
                        Set<String> words = new HashSet<String>(new TextFile(new File(dir, name).getAbsolutePath(), "\\W+"));
                        for(int i = 1; i < args.length; i++){
                            if(words.contains(args[i])){
                                return true;
                            }
                        }
                    }
                    return false;
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String item : list){
            System.out.println(item);
        }
    }
}
