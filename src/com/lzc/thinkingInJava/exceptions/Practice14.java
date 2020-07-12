package com.lzc.thinkingInJava.exceptions;

public class Practice14 {
    private static Switch sw = new Switch();
    private static Integer x[] = new Integer[1];
    public static void f(int i) throws OnOffException1, OnOffException2{}
    public static void main(String[] args){
        try{
            sw.on();
            f(x[0]);
            sw.off();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
            sw.off();
        }
    }
}
