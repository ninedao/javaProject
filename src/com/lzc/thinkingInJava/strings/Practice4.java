package com.lzc.thinkingInJava.strings;

import java.util.Formatter;

public class Practice4 {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private Integer W1 = 15;
    private Integer W2 = 5;
    private Integer W3 = 10;
    private String S1 = "%-" + W1 + "s %" + W2 + "s %" + W3 + "s\n";
    private String S2 = "%-" + W1 + ".15s %" + W2 + "d %" + W3 + ".2f\n";
    private String S3 = "%-" + W1 + "s %" + W2 + "s %" + W3 + ".2f\n";

    public void printTitle(){
        f.format(S1, "Item", "Qty", "Price");
        f.format(S1, "----", "---", "-----");
    }
    public void print(String name, int qty, double price){
        f.format(S2, name, qty, price);
        total += price;
    }
    public void printTotal(){
        f.format(S3, "Tax", "", total*0.06);
        f.format(S1, "", "", "-----");
        f.format(S3, "Total", "", total*1.06);
    }
    public static void main(String[] args){
        Practice4 r = new Practice4();
        r.printTitle();
        r.print("Jack's Magix Beans", 4, 4.25);
        r.print("Princess peas", 3, 5.1);
        r.print("Three Bears Porridge", 1, 14.29);
        r.printTotal();
    }
}
