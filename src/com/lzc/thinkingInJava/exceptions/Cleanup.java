package com.lzc.thinkingInJava.exceptions;

import java.io.FileNotFoundException;

public class Cleanup {
    public static void main(String[] args){
        try{
            InputFile in = new InputFile("src/com/lzc/thinkingInJava/exceptions/Cleanup.java");
            try{
                String s;
                int i = 1;
                while((s = in.getLine()) != null){

                }
            } catch (Exception e){
                System.out.println("Caught Exception in main");
                e.printStackTrace();
            } finally {
                in.dispose();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
