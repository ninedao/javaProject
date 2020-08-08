package com.lzc.thinkingInJava.typeinfo;



public class Practice4 {
    public static void main(String[] args){
        Shape[] s = {new Circle(), new Square(), new Triangle(), new Rhomboid()};
        for(Shape e : s){
            e.draw();
        }
        Shape a = new Rhomboid();
        if(a instanceof Rhomboid) {
            Rhomboid b = (Rhomboid) a;
            b.draw();
        }
        if(a instanceof Circle) {
            Circle b = (Circle) a;
            b.draw();
        }
    }
}
