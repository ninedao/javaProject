package com.lzc.thinkingInJava.exceptions;

public class Practice2 {
    public void d(){
        System.out.println(1);
    }
    public static void main(String[] args){
        Practice2 p2 = null;
        try {
            p2.d();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
