package com.lzc.thinkingInJava.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
    public static void main(String[] args) throws IOException {
        String name = input.readLine();
        System.out.println(name);
        String numbers = input.readLine();
        System.out.println(numbers);
        String[] numArray = numbers.split(" ");
        int age = Integer.valueOf(numArray[0]);
        double favorite = Double.parseDouble(numArray[1]);
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you will be %d.\n", age +5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}
