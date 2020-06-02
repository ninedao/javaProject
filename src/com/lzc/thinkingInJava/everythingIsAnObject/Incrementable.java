package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
public class Incrementable{
	static int i = 0;
	static void increment(){
		i++;
	}
	public static void main(String[] args){
		print(i);
		increment();
		print(i);
	}
}
