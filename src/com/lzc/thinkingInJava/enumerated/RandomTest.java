package com.lzc.thinkingInJava.enumerated;

import com.lzc.thinkingInJava.util.Enums;

enum Acticity {
    SiTTING,LYING,STANDING,HOPPING,RUNNING,DODGINGMJUMPING,FALLING,FLYING
}
public class RandomTest {
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            System.out.println(Enums.random(Acticity.class));
        }
    }
}
