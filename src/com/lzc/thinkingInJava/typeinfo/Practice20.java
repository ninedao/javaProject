package com.lzc.thinkingInJava.typeinfo;

public class Practice20 {

    public static void display(String name, Object[] objs){
        System.out.println(name);
        for(Object obj : objs) {
            System.out.println(" " + obj);
        }
    }
    public static void classInfo(Class<?> c) {
        System.out.println("c.getName(): " + c.getName());
        System.out.println("c.getPackage(): " + c.getPackage());
        System.out.println("c.getSuperclass(): " + c.getSuperclass());
        display("c.getDeclaredClassed()", c.getDeclaredClasses());
        display("c.getClasses()", c.getClasses());
        display("c.getInterfaces()", c.getInterfaces());
        display("c.getDeclaredMethods()", c.getDeclaredMethods());
        display("c.getMethods()", c.getMethods());
        display("c.getDeclaredConstructors()", c.getDeclaredConstructors());
    }
    public static void main(String[] args) {
        classInfo(Practice20.class);
    }
}
