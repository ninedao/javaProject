package com.lzc.thinkingInJava.typeinfo;



public class Practice8 {
    static void printClasses(Class<?> t) throws ClassNotFoundException {
        if(t == null) {
            return;
        }
        System.out.println(t.getCanonicalName());
        for(Class<?> e : t.getInterfaces()) {
            System.out.println("Interface: " + e.getCanonicalName());
            printClasses(e.getSuperclass());
        }
        printClasses(t.getSuperclass());
    }
    public static void main(String[] args){
        try {
            printClasses(Class.forName("com.lzc.thinkingInJava.typeinfo.FancyToy2"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
