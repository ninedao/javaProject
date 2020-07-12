package com.lzc.thinkingInJava.exceptions;

import com.lzc.thinkingInJava.polymorphism.Frog;

public class Practice17 {
    public static void main(String[] args) {
        Frog f = new Frog();
        try {
            System.out.println("Returning from try-finally");
            return;
        } finally {
            f.dispose();
        }
    }
}
