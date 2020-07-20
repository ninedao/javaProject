package com.lzc.thinkingInJava.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class Practice3 {
    private String name;
    private Formatter f;
    public Practice3(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }
    public static void main(String[] args){
        PrintStream outAlias = System.err;
        Practice3 tommy = new Practice3("Tommy", new Formatter(System.err));
        Practice3 terry = new Practice3("Terry", new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,5);

        tommy.move(3,4);
        terry.move(2,5);

        tommy.move(3,3);
        terry.move(3,3);
    }
}
