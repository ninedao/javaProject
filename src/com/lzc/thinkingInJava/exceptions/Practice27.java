package com.lzc.thinkingInJava.exceptions;

public class Practice27 {
    public static void main(String[] args){
        Integer[] array = new Integer[10];
        try {
            array[10] = 10;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
