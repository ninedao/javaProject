package com.lzc.thinkingInJava.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SmartToy extends FancyToy {
    private Integer IQ;
    public SmartToy (int intelligence) {
        IQ = intelligence;
    }

    @Override
    public String toString() {
        return "I'm a SuperToy, I'm smarter than you";
    }
}
public class Practice19 {
    public static Toy makeToy(String name, int IQ) {
        try {
            Class c = Class.forName(name);
            for(Constructor cc : c.getConstructors()){
                Class<?>[] p = cc.getParameterTypes();
                if(p.length ==1 && p[0] == int.class) {
                    return (SmartToy)cc.newInstance(100);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(makeToy("com.lzc.thinkingInJava.typeinfo.SmartToy",100));
    }
}
