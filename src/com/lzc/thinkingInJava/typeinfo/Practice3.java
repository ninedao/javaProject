package com.lzc.thinkingInJava.typeinfo;


class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class Practice3 {
    public static void main(String[] args){
        Shape[] s = {new Circle(), new Square(), new Triangle(), new Rhomboid()};
        for(Shape e : s){
            e.draw();
        }
        Shape a = new Rhomboid();
        Rhomboid b = (Rhomboid) a;
        b.draw();
        //Circle c = (Circle) a;
    }
}
