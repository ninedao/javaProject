package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;

class Apple{
    private static long counter;
    private final long id = counter++;
    public long id(){
        return id;
    }
}
class Orangle{}

public class ApplesAndOrangesWithoutGeneries {

    public static void main(String[] args){
        System.out.println("test1()");
        try {
            test1();
        }catch(Exception e){
            throw e;
        }finally {
            System.out.println("test2()");
            test2();
        }

    }
    /*
     *
     * output :0
     * 0
     * 0
     * Exception in thread "main" java.lang.ClassCastException: com.lzc.thinkingInJava.holding.Orangle cannot be cast to com.lzc.thinkingInJava.holding.Apple
     * 	at com.lzc.thinkingInJava.holding.ApplesAndOrangesWithoutGeneries.main(ApplesAndOrangesWithoutGeneries.java:22)
     *
     * */
    @SuppressWarnings("unchecked")
    public static void test1(){
        ArrayList apples = new ArrayList();
        for(int i = 0; i < 3; i++){
            apples.add(new Apple());
        }
        apples.add(new Orangle());
        for(int i = 0; i < apples.size(); i++){
            System.out.println(((Apple)apples.get(i)).id());
        }
    }
    public static void test2(){
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i = 0; i < 3; i++){
            apples.add(new Apple());
        }
        //apples.add(new Orangle());
        for(int i = 0; i < apples.size(); i++){
            System.out.println(((Apple)apples.get(i)).id());
        }
    }
}
