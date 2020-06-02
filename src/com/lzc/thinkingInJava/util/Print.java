package com.lzc.thinkingInJava.util;
import java.io.*;
public class Print{
	public static void print(Object s){
		System.out.println(s);
	}
	public static void print(){
		System.out.println();
	}
	public static void printa(Object s){
		System.out.print(s);
	}
	public static PrintStream printf(String format, Object... args){
		return System.out.printf(format, args);
	}
}
