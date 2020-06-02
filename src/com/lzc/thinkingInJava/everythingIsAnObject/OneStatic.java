package com.lzc.thinkingInJava.everythingIsAnObject;
import static com.lzc.thinkingInJava.util.Print.*;
class StaticTest{
	static int i = 1;
}

public class OneStatic{
	static void increment(){
		StaticTest.i++;
	}
	public static void main(String[] args){
		print("StaticTest.i = " + StaticTest.i);
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		print("st1.i = " + st1.i);
		print("st2.i = " + st2.i);
		increment();
		print("After increment;");
		print("st1.i = " + st1.i);
		print("st2.i = " + st2.i);
	}
}
