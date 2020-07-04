package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class GrannySmith extends Apple{}
class Gala extends Apple{}
class Fuji extends Apple{}
class Braeburn extends Apple{}
public class GenericsAndUpcasting {
    public static void main(String[] args){
        //Collection s = new ArrayList<String>();
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for(Apple c : apples){
            System.out.println(c);
        }
    }
}
