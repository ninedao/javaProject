package com.lzc.thinkingInJava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class RecoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Circle.deseserializeStaticState(in);
        Square.deseserializeStaticState(in);
        Line.deseserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        in.close();
        System.out.println(shapeTypes);
        System.out.println(shapes);
    }
}
