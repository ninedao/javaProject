package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.Arrays;

class Container extends ArrayList<Product> {
    public Container(int nProduct) {
        Generators.fill(this, Product.generator, nProduct);
    }
}
class CargoHold extends ArrayList<Container> {
    public CargoHold(int nShelves, int nproduct) {
        for(int i = 0; i < nproduct; i++) {
            add(new Container(nproduct));
        }
    }
}
class Crane{}
class CommandSection{}
public class E19_Freighter extends ArrayList<CargoHold> {
    private ArrayList<Crane> c = new ArrayList<Crane>();
    private CommandSection commandSection = new CommandSection();
    public E19_Freighter(int nAisle, int nShelves, int nproduct){
        for(int i = 0; i< nAisle; i++) {
            add(new CargoHold(nShelves, nproduct));
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(CargoHold a : this) {
            for(Container b : a) {
                for(Product c : b) {
                    result.append(c);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(new E19_Freighter(14,5, 10));
    }
}