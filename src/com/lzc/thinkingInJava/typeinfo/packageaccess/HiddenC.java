package com.lzc.thinkingInJava.typeinfo.packageaccess;

import com.lzc.thinkingInJava.typeinfo.interfacea.A;

import static com.lzc.thinkingInJava.util.Print.print;

class C implements A {
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
}
public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
