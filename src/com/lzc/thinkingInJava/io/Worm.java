package com.lzc.thinkingInJava.io;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

class Data implements Serializable {
    private int n;
    public Data(int n){
        this.n = n;
    }
    public String toString(){
        return Integer.toString(n);
    }
}
public class Worm implements Serializable{
    private static Random rand = new Random(47);
    private Data[] a = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if(--i > 0){
            next = new Worm(i,(char)(x + 1));
        }
    }
    public Worm(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(c);
        result.append("(");
        for(Data dat : a) {
            result.append(dat);
        }
        result.append(")");
        if(next != null){
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();
        System.out.println(s + "w2 = " + w2);
        in.close();

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.close();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        String s2 = (String)in2.readObject();
        Worm w3 = (Worm)in2.readObject();
        System.out.println(s2 + "w3 = " + w3);
        in2.close();
    }
}
