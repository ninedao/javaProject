package com.lzc.thinkingInJava.typeinfo.classa;

import static com.lzc.thinkingInJava.util.Print.print;

public class A {
    private void u() {
        print("private A.u()");
    }
    protected void v() {
        print("protected A.v()");
    }
    void w() {
        print("package A.w()");
    }
}
