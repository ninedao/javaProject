package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.Random;

public class E06_RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public void add(T item) {
        storage.add(item);
    }
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main(String[] args) {
        E06_RandomList<String> rs = new E06_RandomList<String>();
        for(String s : "The quick brown fox jumped over the lazy brown dog".split(" ")){
            rs.add(s);
        };
        for(int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
        System.out.println();
        E06_RandomList<Integer> rs1 = new E06_RandomList<Integer>();
        for(int i = 0; i < 11; i++){
            rs1.add(i);
        };
        for(int i = 0; i < 11; i++) {
            System.out.print(rs1.select() + " ");
        }
        System.out.println();
        E06_RandomList<Character> rs2 = new E06_RandomList<Character>();

        for(int i = 'A'; i <= 'Z'; i++){
            rs2.add((char) i);
        };
        for(int i = 0; i < 30; i++) {
            System.out.print(rs2.select() + " ");
        }
    }
}
