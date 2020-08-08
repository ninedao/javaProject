package com.lzc.thinkingInJava.typeinfo;

class Candy {
    static{
        System.out.println("Loading Candy");
    }
}
class Gum {
    static{
        System.out.println("Loading Gum");
    }
    public void f() {
        System.out.println("Gum.f()");
    }
}
class Cookie {
    static{
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class<Gum> m = (Class<Gum>) Class.forName("com.lzc.thinkingInJava.typeinfo.Gum");
            m.newInstance().f();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
