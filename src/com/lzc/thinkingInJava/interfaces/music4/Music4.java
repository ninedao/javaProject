package com.lzc.thinkingInJava.interfaces.music4;
class test{
    void f(){
	System.out.println("test");
    }
}
public class Music4 extends test{
    void m(){
    	System.out.println("m");
    }
    public static void main(String[] args){
	test t = new Music4();
	Music4 m = (Music4)t;
	m.m();
	//t.m();
    } 
}
