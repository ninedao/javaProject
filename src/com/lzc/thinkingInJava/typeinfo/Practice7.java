package com.lzc.thinkingInJava.typeinfo;



public class Practice7 {
    public static void main(String[] args){
        args = new String[2];
        args[0] = "com.lzc.thinkingInJava.typeinfo.Candy";
        args[1] = "com.lzc.thinkingInJava.typeinfo.Cookie";
        for(String e : args) {
           try {
               Class.forName(e);
           } catch (ClassNotFoundException classNotFoundException) {
               classNotFoundException.printStackTrace();
           }
        }
    }
}
