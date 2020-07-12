package com.lzc.thinkingInJava.exceptions;

class Exception251 extends Exception{}
class Exception252 extends Exception251{}
class Exception253 extends Exception252{}

class A {
    void f() throws Exception251 {
        throw new Exception251();
    }
}
class B extends A {
    void f() throws Exception252 {
        throw new Exception252();
    }
}
class C extends B {
    void f() throws Exception253 {
        throw new Exception253();
    }
}
public class Practice25 {
    public static void main(String[] args){
        A a = new C();
        try {
            a.f();
        } catch (Exception253 exception253) {
            exception253.printStackTrace();
        } catch (Exception252 exception252) {
            exception252.printStackTrace();
        } catch (Exception251 exception251) {
            exception251.printStackTrace();
        }
    }
}
