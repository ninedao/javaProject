package com.lzc.thinkingInJava.exceptions;

public class Practice3 {
    public void d(){
        System.out.println(1);
    }
    public static void main(String[] args){
        String[] array = new String[10];
        try {
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
