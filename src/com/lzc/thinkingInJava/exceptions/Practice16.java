package com.lzc.thinkingInJava.exceptions;

import com.lzc.thinkingInJava.reusing.CADSystem;

public class Practice16 {
    public static void main(String[] args) {
        CADSystem c = new CADSystem(47);
        try {
            System.out.println("Returning from try block");
            return;
        } finally {
            c.dispose();
        }
    }
}
