package com.lzc.thinkingInJava.holding;


import java.util.*;

public class Practice4 {
    static int key = 0;
    static String next(){
        switch(key){
            default:
            case 0 : key++; return "Snow White";
            case 1 : key++; return "Bashful";
            case 2 : key++; return "Doc";
            case 3 : key++; return "Dopey";
            case 4 : key++; return "Grumpy";
            case 5 : key++; return "Happy";
            case 6 : key++; return "Sleepy";
            case 7 : key = 0; return "Sneezy";
        }
    }
    static Collection fill(Collection<String> c, int len){
        for(int i = 0; i < len; i++){
            c.add(next());
        }
        return c;
    }
    static void fill(String[] a){
        for(int i = 0; i < a.length; i++){
            a[i] = next();
        }
    }
    public static void main(String[] args){
        String[] a = new String[10];
        fill(a);
        for(String e : a){
            System.out.print(e + ", ");
        }
        System.out.println();
        System.out.println(fill(new ArrayList<String>(), 10));
        System.out.println(fill(new LinkedList<String>(), 10));
        System.out.println(fill(new HashSet<String>(), 10));
        System.out.println(fill(new TreeSet<String>(), 10));
        System.out.println(fill(new LinkedHashSet<String>(), 10));
    }
}
