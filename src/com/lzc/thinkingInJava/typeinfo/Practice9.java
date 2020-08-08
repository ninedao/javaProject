package com.lzc.thinkingInJava.typeinfo;


import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
interface Iface {
    int i = 47;
    void f();
}
class Base implements Iface {
    String s;
    double d;
    @Override
    public void f() {
        System.out.println("Base.f");
    }
}
class Composed {
    Base b;
}
class Derived extends Base {
    Composed c;
    String s;
}
public class Practice9 {
    static Set<Class<?>> alreadyDisplayed = new HashSet<Class<?>>();
    static void printClasses(Class<?> t) throws ClassNotFoundException {
        if(t == null) {
            return;
        }
        System.out.println(t.getCanonicalName());
        Field[] fields = t.getDeclaredFields();
        if(fields.length > 0){
            System.out.println("Fields: ");
        }
        for(Field f : fields){
            System.out.println("    " + f);
        }
        for(Field f : fields) {
            Class<?> k = f.getType();
            if(!alreadyDisplayed.contains(k)) {
                printClasses(k);
                alreadyDisplayed.add(k);
            }
        }
        for(Class<?> e : t.getInterfaces()) {
            System.out.println("Interface: " + e.getCanonicalName());
            printClasses(e.getSuperclass());
        }
        printClasses(t.getSuperclass());
    }
    public static void main(String[] args){
        try {
            printClasses(Class.forName("com.lzc.thinkingInJava.typeinfo.Derived"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
