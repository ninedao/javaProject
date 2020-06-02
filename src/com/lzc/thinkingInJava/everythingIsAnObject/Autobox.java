package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
public class Autobox{
	public static void main(String[] args){
		boolean b = false;
		char c = 'x';
		byte t = 8;
		short s = 16;
		int i = 32;
		long l = 64;
		float f = 0.32f;
		double d = 0.64;
		Boolean B = b;
		print("boolean b = " + b);
		print("Boolean B = " + B);
		Character C = c;
		print("char c = " + c);
		print("Character C = " + C);
		Byte T = t;
		print("byte t = " + t);
		print("Byte T = " + T);
		Integer I = i;
		print("int i = " + i);
		print("Integer I = " + I);
		Long L = l;
		print("long l = " + l);
		print("Long L = " + L);
		Float F = f;
		print("float f = " + f);
		print("Float F = " + F);
		Double D = d;
		print("double d = " + d);
		print("Double D = " + D);
	}
}
