package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.typeinfo.pets.Dog;

class PerformingDog extends Dog implements  Performs {
    @Override
    public void speak() {
        System.out.println("Woot");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }
}
class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Click!");
    }

    @Override
    public void sit() {
        System.out.println("Clank!");
    }
}
class Communicate {
    public static <T extends Performs> void perform(T perform){
        perform.speak();
        perform.sit();
    }
}
public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog dog = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(dog);
        Communicate.perform(r);
    }
}
