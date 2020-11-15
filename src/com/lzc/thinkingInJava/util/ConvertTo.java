package com.lzc.thinkingInJava.util;

import java.util.Arrays;

public class ConvertTo {
    public static boolean[] primitive(Boolean[] in) {
        boolean t[] = new boolean[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static byte[] primitive(Byte[] in) {
        byte t[] = new byte[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static short[] primitive(Short[] in) {
        short t[] = new short[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static int[] primitive(Integer[] in) {
        int t[] = new int[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }

    public static long[] primitive(Long[] in) {
        long t[] = new long[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static char[] primitive(Character[] in) {
        char t[] = new char[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static float[] primitive(Float[] in) {
        float t[] = new float[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }
        return t;
    }
    public static double[] primitive(Double[] in) {
        double t[] = new double[in.length];
        for(int i = 0; i < in.length; i++){
            t[i] = in[i];
        }

        return t;

    }
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j =new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j,96);
        System.arraycopy(i,0,j,0,i.length-1);
        System.out.println(Arrays.toString(j));
    }
}
