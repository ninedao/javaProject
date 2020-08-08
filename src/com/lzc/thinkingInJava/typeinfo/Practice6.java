package com.lzc.thinkingInJava.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Practice6Shape {
    protected boolean highleighted = false;
    public void highLeight(){
        highleighted = true;
    }
    public void clearHighLeight(){
        highleighted = false;
    }
    void draw(){
        System.out.println(this + "draw");
    }
    public String toString() {
        return getClass().getSimpleName() + (highleighted ? " highleighted " : " normal ");
    };
    static List<Practice6Shape> shapes = new ArrayList<Practice6Shape>();
    public Practice6Shape(){
        shapes.add(this);
    }
    public static void highLeight1(Class<?> type){
        for(Practice6Shape shape : shapes) {
            if(type.isInstance(shape)) {
                shape.highLeight();
            }
        }
    }
    public static void clearHighLeight1(){
        for(Practice6Shape shape : shapes) {
            shape.clearHighLeight();
        }
    }
    public static void forEach(Class<?> type, String method) {
        try {
            Method m = Practice6Shape.class.getMethod(method);
            for(Practice6Shape shape : shapes) {
                if(type.isInstance(shape)) {
                    m.invoke(shape);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    static void highLeight2(Class<?> type){
        forEach(type, "highLeight");
    }
    public static void clearHighLeight2(Class<?> type){
        forEach(type, "clearHighLeight");
    }
}

class Practice6Circle extends Practice6Shape {}

class Practice6Square extends Practice6Shape {}

class Practice6Triangle extends Practice6Shape {}

public class Practice6 {
    public static void main(String[] args){
        List<Practice6Shape> shapes = Arrays.asList(
                new Practice6Circle(), new Practice6Square(),
                new Practice6Triangle(), new Practice6Square(),
                new Practice6Triangle(), new Practice6Circle(),
                new Practice6Circle(), new Practice6Square()
        );
        Practice6Shape.highLeight1(Practice6Circle.class);
        Practice6Shape.highLeight2(Practice6Circle.class);
        for(Practice6Shape shape : shapes) {
            shape.draw();
        }
        System.out.println("**********");
        Practice6Shape.highLeight1(Practice6Shape.class);
        Practice6Shape.highLeight2(Practice6Shape.class);
        for(Practice6Shape shape : shapes) {
            shape.draw();
        }
        System.out.println("**********");
        Practice6Shape.highLeight1(ArrayList.class);
        Practice6Shape.highLeight2(ArrayList.class);
        for(Practice6Shape shape : shapes) {
            shape.draw();
        }
    }
}
