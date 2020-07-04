package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;

class Gerbil{
    private static int counter ;
    private final int gerbilNumber = counter++;
    public void hop(){
        System.out.println(gerbilNumber + " is hopping");
    }
}
public class Practice1 {
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i = 0; i < 3; i++){
            gerbils.add(new Gerbil());
            gerbils.get(i).hop();
        }

    }
}
