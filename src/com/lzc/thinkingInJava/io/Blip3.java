package com.lzc.thinkingInJava.io;

import java.io.*;
public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x, int a){
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return "Blip3{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip3 b3 = new Blip3("A String", 47);
        System.out.println(b3);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        objectOutputStream.writeObject(b3);
        objectOutputStream.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        b3 = (Blip3)in.readObject();
        System.out.println(b3);
    }
}
