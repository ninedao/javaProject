package com.lzc.coreJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
    public static void printConstructors(Class cl){
        Constructor[] methods = cl.getDeclaredConstructors();
        for(Constructor c : methods){
            String name = c.getName();
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] classes = c.getParameterTypes();
            for(int i = 0; i < classes.length; i++){
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(classes[i].getName());
            }
            System.out.println(");");
        }
    }
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields){
            String name = f.getName();
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.println(f.getType().getName() + " " + name +";");
        }
    }
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for(Method m : methods){
            String name = m.getName();
            String modifers = Modifier.toString(m.getModifiers());
            if(modifers.length() > 0){
                System.out.print(modifers + " ");
            }
            Class returnName = m.getReturnType();
            System.out.print(returnName.getName() + " ");
            Class[] classes = m.getParameterTypes();
            System.out.print(name + "(");
            for(int i = 0; i < classes.length; i++){
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(classes[i].getName());
            }
            System.out.println(");");
        }

    }
    public static void analyClass(String name) throws ClassNotFoundException{
        Class cl = Class.forName(name);

        String modifers = Modifier.toString(cl.getModifiers());
        if(modifers.length() > 0){
            System.out.print(modifers + " ");
        }
        System.out.println(name + "{");
        printFields(cl);
        System.out.println();
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println("}");
    }
    public static void main(String[] args){
        try {
            analyClass("com.lzc.coreJava.innerClass.TalkingClock$1TimePrinter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        List<String> ttttt = new ArrayList<String>();
//
//        ttttt.contains("");
//        try {
//            Class s = TestTest.class;
//            s.getComponentType();
//            Constructor ss = s.getDeclaredConstructor(String.class);
//            ss.setAccessible(true);
//            TestTest ttt = (TestTest) ss.newInstance("mm");
//            Method mm = s.getDeclaredMethod("getTe");
//            mm.setAccessible(true);
//            mm.invoke(ttt);
//            Field f = s.getDeclaredField("te");
//            f.setAccessible(true);
//            f.set(ttt,"nnn");
//            mm.invoke(ttt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
class TestTest{
    private String te ;
    private TestTest(String m) {
        this.te = m;
    }
    private void getTe(){
        System.out.println(te);
    }
}