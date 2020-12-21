package com.lzc.thinkingInJava.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args) {
        try{
            if(args.length == 0){
                processDirectoryTree(new File("."));
            }else{
                for(String arg : args){
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }else{
                        if(!arg.endsWith("." + ext)){
                            arg += "." + ext;
                        }

                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void processDirectoryTree(File root) {
        for(File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)){
            strategy.process(file);
        }
    }

    public static void main(String[] args) throws IOException {
        args = new String[]{
              "C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src",
                "C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java"
        };
        //System.out.println(new File("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\Test.java").getCanonicalFile());
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
