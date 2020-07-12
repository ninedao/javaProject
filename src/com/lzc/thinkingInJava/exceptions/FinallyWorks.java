package com.lzc.thinkingInJava.exceptions;

class TreeException extends Exception {}
public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args){
        while(true) {
            try {
                if(count++ == 0) {
                    throw new TreeException();
                }
                System.out.println("No Exception");
            } catch (TreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally Clause");
                if(count == 2){
                    break;
                }
            }
        }
    }
}
