package com.lzc.thinkingInJava.containers;

public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    abstract int test(C list, TestParam tp);
}
