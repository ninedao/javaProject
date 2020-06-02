package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
public class DataOnly{
	int i;
	double d;
	boolean b;
	void show(){
		print("i is " + i + ",d is " + d +",b is " + b);
	}
	public static void main(String[] args){
		DataOnly a = new DataOnly();
		a.i = 1;
		a.d = 2.7817;
		a.b = true;
		a.show();
	}
}
