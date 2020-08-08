package com.lzc.thinkingInJava.typeinfo;

import com.lzc.thinkingInJava.typeinfo.classa.A;

import static com.lzc.thinkingInJava.typeinfo.HiddenImplementation.callHiddenMethod;

public class Practice25 {
    public static void main(String[] args) throws Exception {
        class B extends A {
            protected void v() {
                super.v();
            }
        }
        A objA = new A();
        callHiddenMethod(objA, "u");
        callHiddenMethod(objA, "v");
        callHiddenMethod(objA, "w");
        B objB = new B();
        objB.v();
    }
}
