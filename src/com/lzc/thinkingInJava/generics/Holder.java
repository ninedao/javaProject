package com.lzc.thinkingInJava.generics;

public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T val){
        this.value = val;
    }
    public void set(T val){
        this.value = val;
    }
    public T get(){
        return value;
    }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        //Holder<Fruit> fruitHolder = apple;
        Holder<? extends Fruit> fruitHolder = apple;
        Fruit f = fruitHolder.get();
        d = (Apple) fruitHolder.get();
        try {
            Orange c = (Orange) fruitHolder.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        //fruitHolder.set(new Apple());
        //fruitHolder.set(new Fruit());
        System.out.println(fruitHolder.equals(d));
    }
}
