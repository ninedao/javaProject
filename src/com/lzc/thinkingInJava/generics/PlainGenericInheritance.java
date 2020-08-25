package com.lzc.thinkingInJava.generics;

class GenericSetter<T> {
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}
class DerivedGs extends GenericSetter<Base> {
    void set(Derived arg) {
        System.out.println("DerivedGs.set(Base)");
    }
}
public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGs derivedGs = new DerivedGs();
        derivedGs.set(derived);//重写，而非重载
        derivedGs.set(base);
    }
}
