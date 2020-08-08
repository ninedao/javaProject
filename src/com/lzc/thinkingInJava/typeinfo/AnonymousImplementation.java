package com.lzc.thinkingInJava.typeinfo;

import com.lzc.thinkingInJava.typeinfo.interfacea.A;

import static com.lzc.thinkingInJava.util.Print.print;

class AnonymousA {
    public static A makeA() {
        return new A() {
            @Override
            public void f() {
                print("public C.f()");
            }
            public void g() {
                print("public C.g()");
            }
            public void u() {
                print("package C.u()");
            }
            protected void v() {
                print("protected C.v()");
            }
            private void w() {
                print("private C.w()");
            }
        };
    }
}
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
