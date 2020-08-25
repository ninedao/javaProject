package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Product {
    private final int id;
    private String description;
    private double price;
    public Product(int IDnumber, String desc, double price) {
        this.id  =IDnumber;
        this.description = desc;
        this.price = price;
    }
    public String toString(){
        return id + ": " + description + ", price: $" + price;
    }
    public void priceChange(double change) {
        price += change;
    }
    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000) + 0.99);
        }
    };
}
class Shelf extends ArrayList<Product> {
    public Shelf(int nProduct) {
        Generators.fill(this, Product.generator, nProduct);
    }
}
class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nproduct) {
        for(int i = 0; i < nproduct; i++) {
            add(new Shelf(nproduct));
        }
    }
}
class CheckoutStand{}
class Office{}
public class Store extends ArrayList<Aisle>  {
    private ArrayList<CheckoutStand> c = new ArrayList<CheckoutStand>();
    private Office office = new Office();
    public Store(int nAisle, int nShelves, int nproduct){
        for(int i = 0; i< nAisle; i++) {
            add(new Aisle(nShelves, nproduct));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Aisle a : this) {
            for(Shelf b : a) {
                for(Product c : b) {
                    result.append(c);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Store(14,5, 10));
    }
}
