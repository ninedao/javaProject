package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.polymorphism.shape.Circle;
import com.lzc.thinkingInJava.polymorphism.shape.Shape;
import com.lzc.thinkingInJava.polymorphism.shape.Square;
import com.lzc.thinkingInJava.polymorphism.shape.Triangle;

import java.util.Iterator;
import java.util.Random;

public class Practice31 implements Iterable<Shape> {
    private Random rand = new Random(47);
    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
    private Shape[] shapes;
    public Practice31(int i) {
        shapes = new Shape[11];
        for (int j = 0; j < i; j++) {
            shapes[j] = next();
        }
    }
    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < shapes.length;
            }

            @Override
            public Shape next() {
                return shapes[i++];
            }
        };
    }
    public static void main(String[] args){
        for(Shape e : new Practice31(11)){
            e.draw();
        }
    }
}
