package com.lzc.thinkingInJava.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ClassAsFactory1<T> {
    Class<T> kind;
    public ClassAsFactory1(Class<T> kind) {
        this.kind = kind;
    }
    public T create(int args) {
        for(Constructor<?> con : kind.getConstructors()) {
            Class[] classes = con.getParameterTypes();
            if(classes.length == 1) {
                if(classes[0] == int.class) {
                    try {
                        return kind.cast(con.newInstance(args));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }
}
public class E22_InstantiateGenericType2 {
    public static void main(String[] args) {
        ClassAsFactory1<Employee> e = new ClassAsFactory1<Employee>(Employee.class);
        Employee ee = e.create(1);
        if(ee == null) {
            System.out.println("Employee cann't be instantiate");
        }else{
            System.out.println(e.create(1));
        }
        ClassAsFactory1<Integer> c = new ClassAsFactory1<Integer>(Integer.class);
        if(c == null) {
            System.out.println("Integer cann't be instantiate");
        }else{
            System.out.println(c.create(1));
        }

    }
}
