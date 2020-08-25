package com.lzc.thinkingInJava.generics;

class OrdinarySetter {
    void set(Base base){
        System.out.println("OrdinarySetter.set(Base)");
    }
}
class DerivedSetter extends OrdinarySetter {
    void set(Derived base){
        System.out.println("DerivedSetter.set(Derived)");
    }
}
public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        ds.set(base);//重载方法，不是重写方法
    }
}
