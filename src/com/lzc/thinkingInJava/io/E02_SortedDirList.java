package com.lzc.thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class SortedDirList {
    private String path;
    public SortedDirList(String name){
        this.path = name;
    }
    public String[] list(){
        String[] list = new File(path).list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public String[] list(final String regex){
        String[] list = new File(path).list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        return list;
    }
}
public class E02_SortedDirList {
    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers");
        System.out.println(Arrays.toString(sortedDirList.list()));
    }
}
