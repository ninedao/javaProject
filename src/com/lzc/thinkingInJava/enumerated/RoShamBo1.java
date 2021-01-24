package com.lzc.thinkingInJava.enumerated;

import java.util.Random;

import static com.lzc.thinkingInJava.enumerated.Outcome.*;

interface Item{
    Outcome compete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors p);
    Outcome eval(Rock p);

}
class Paper implements Item{

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors p) {
        return WIN;
    }

    @Override
    public Outcome eval(Rock p) {
        return LOSE;
    }
}
class Scissors implements Item{

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return LOSE;
    }

    @Override
    public Outcome eval(Scissors p) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock p) {
        return WIN;
    }
}
class Rock implements Item{

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return WIN;
    }

    @Override
    public Outcome eval(Scissors p) {
        return LOSE;
    }

    @Override
    public Outcome eval(Rock p) {
        return DRAW;
    }
}
public class RoShamBo1 {
    private static Random random = new Random(47);
    public static Item nextItem(){
        switch (random.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Rock();
            case 2: return new Paper();
        }
    }
    public static void match(Item a, Item b) {
        System.out.println(a.getClass().getSimpleName() + " vs. " + b.getClass().getSimpleName() +": " + a.compete(b));
    }
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            match(nextItem(),nextItem());
        }
    }
}
