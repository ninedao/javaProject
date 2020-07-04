package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Iterator;


public class Practice9 {
    private ArrayList items ;
    public Practice9(){
        items = new ArrayList();
    }
    public void add(Object o){
        items.add(o);
    }
    public Iterator iterator(){
        return items.iterator();
    }
    public static void main(String[] args){
        Practice9 p = new Practice9();
        for(int i = 0; i <= 10; i++){
            p.add(i);
        }
        Iterator s = p.iterator();
        while(s.hasNext()){
            System.out.print(s.next() + " ");
        }
    }
}
