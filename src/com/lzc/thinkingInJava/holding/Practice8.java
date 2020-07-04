package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Iterator;


public class Practice8 {
    static class Gerbil{
        private static int counter ;
        private final int gerbilNumber = counter++;
        public void hop(){
            System.out.println(gerbilNumber + " is hopping");
        }
    }
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i = 0; i < 10; i++){
            gerbils.add(new Gerbil());
        }
        Iterator<Gerbil> it = gerbils.iterator();
        while(it.hasNext()){
            it.next().hop();
        }

    }
}
