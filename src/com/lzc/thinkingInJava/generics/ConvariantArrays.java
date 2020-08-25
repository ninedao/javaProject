package com.lzc.thinkingInJava.generics;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}
public class ConvariantArrays {
    public static void main(String[] args) {
        Fruit[] f = new Apple[10];
        f[0] = new Apple();
        f[1] = new Jonathan();
        try{
            f[0] = new Fruit();
        } catch(Exception e) {
            System.out.println(e);
        }
        try{
            f[0] = new Orange();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
