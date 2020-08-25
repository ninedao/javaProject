package com.lzc.thinkingInJava.generics.coffee;

import com.lzc.thinkingInJava.util.Generator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>  {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private Random rand = new Random(47);
    public CoffeeGenerator(){}
    private int size = 0;
    public CoffeeGenerator(int size){
        this.size = size;
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }
        };
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for(Coffee s : new CoffeeGenerator(5)){
            System.out.println(s);
        }
    }
}
