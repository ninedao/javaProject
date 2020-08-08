package com.lzc.thinkingInJava.typeinfo;

abstract class Shape5 {
    void draw(){
        System.out.println(this + ".draw");
    }
    public abstract String toString();
    public void rotate(int degrees) {
        System.out.println("Ratating " + this + " by " + degrees + " degrees");
    }
}

class Circle5 extends Shape5 {
    @Override
    public String toString() {
        return "Circle5";
    }

    @Override
    public void rotate(int degrees) {
        throw new UnsupportedOperationException();
    }
}

class Square5 extends Shape5 {
    @Override
    public String toString() {
        return "Square5";
    }
}

class Triangle5 extends Shape5 {
    @Override
    public String toString() {
        return "Triangle5";
    }
}

public class Practice5 {
    public static void main(String[] args){
        Shape5[] s = {new Circle5(), new Square5(), new Triangle5()};
        for(Shape5 e : s){
            if(!(e instanceof Circle5)) {
                e.rotate(60);
            }
        }
    }
}
