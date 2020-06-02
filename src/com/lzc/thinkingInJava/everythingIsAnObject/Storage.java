package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
public class Storage{
	public int storage(String s){
		return s.length() * 2;
	}
	public static void main(String[] args){
		Storage s = new Storage();
		print(s.storage("hi"));	
	} 
}
