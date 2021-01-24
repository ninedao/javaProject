package com.lzc.concurrent.chapter01;

public class ThreadConstruction {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group,"t2");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println(mainGroup.getName());
        System.out.println(t1.getThreadGroup() == t2.getThreadGroup());
        System.out.println(mainGroup == t1.getThreadGroup());
        System.out.println(mainGroup == t2.getThreadGroup());
        System.out.println(group == t2.getThreadGroup());
    }
}
