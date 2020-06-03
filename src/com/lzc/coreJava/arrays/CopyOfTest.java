package com.lzc.corejava.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args){
        int[] a = {1,2,3};
        a = (int[])goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));
        String[] b = {"Tom","Dick","Harry"};
        b = (String[])goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
        b = (String[])badCopyOf(b,10);//会抛出异常 ClassCastException
    }
    public static Object goodCopyOf(Object a, int newLength){
        if(a == null || !a.getClass().isArray()){
            return null;
        }
        Class cl = a.getClass();
        Class ca = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(ca, length);
        System.arraycopy(a, 0,newArray,0, Math.min(length,newLength));
        return newArray;
    }
    public static Object[] badCopyOf(Object[] a, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0,newArray,0, Math.min(a.length,newLength));
        return newArray;
    }
}
