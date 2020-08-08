package com.lzc.thinkingInJava.typeinfo;

abstract class Shape {
    void draw(){
        System.out.println(this + ".draw");
    }
    public abstract String toString();
}
class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}
public class Shapes {
    public static void main(String[] args){
        Shape[] s = {new Circle(), new Square(), new Triangle()};
        for(Shape e : s){
            e.draw();
        }
    }
}
