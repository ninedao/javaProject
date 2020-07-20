package com.lzc.thinkingInJava.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class BetterRead {
    public static Scanner input = new Scanner(SimpleRead.input);
    public static void main(String[] args) throws IOException {
        String name = input.nextLine();
        System.out.println(name);
        int age = Integer.valueOf(input.nextInt());
        double favorite = input.nextDouble();
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you will be %d.\n", age +5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}
