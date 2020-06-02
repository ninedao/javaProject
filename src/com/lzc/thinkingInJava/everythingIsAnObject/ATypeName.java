package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
public class ATypeName{
	int i;
	double d;
	boolean b;
	void show(){
		print("i is " + i + ",d is " + d +",b is " + b);
	}
	public static void main(String[] args){
		ATypeName a = new ATypeName();
		a.i = 1;
		a.d = 2;
		a.b = true;
		a.show();
	}
}
