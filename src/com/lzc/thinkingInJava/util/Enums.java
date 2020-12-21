package com.lzc.thinkingInJava.util;

import com.lzc.thinkingInJava.enumerated.menu.Food;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] ec){
        return ec[rand.nextInt(ec.length)];
    }

}
