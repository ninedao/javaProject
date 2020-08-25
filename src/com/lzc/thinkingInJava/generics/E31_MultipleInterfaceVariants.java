package com.lzc.thinkingInJava.generics;

interface Payable<T> {}

class Employees implements Payable{}

class Hourly extends Employees implements Payable{}

public class E31_MultipleInterfaceVariants {
    public static void main(String[] args){
        Hourly hourly = new Hourly();
    }
}
