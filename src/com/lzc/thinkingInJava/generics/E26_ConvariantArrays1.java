package com.lzc.thinkingInJava.generics;



public class E26_ConvariantArrays1 {
    public static void main(String[] args) {
        Number[] f = new Integer[10];
        f[0] = 1;
        f[1] = 2;
        try{
            f[0] = 1.0;
        } catch(Exception e) {
            System.out.println(e);
        }
        try{
            f[0] = Byte.valueOf((byte)1);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
