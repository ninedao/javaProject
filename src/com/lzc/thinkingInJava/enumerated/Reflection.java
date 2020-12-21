package com.lzc.thinkingInJava.enumerated;

import com.lzc.thinkingInJava.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore{HERE, THERE}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------------- Analyzing " + enumClass + " --------------");
        System.out.println("Interfaces");
        for(Type t : enumClass.getInterfaces()){
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for(Method method : enumClass.getMethods()){
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println(exploreMethods.containsAll(enumMethods));
        System.out.println(exploreMethods.removeAll(enumMethods));
        OSExecute.command("javap  out/production/javaProject/com/lzc/thinkingInJava/enumerated/Explore.class","GBK");
    }
}
