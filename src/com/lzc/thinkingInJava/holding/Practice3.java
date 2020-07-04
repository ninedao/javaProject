package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;

interface Selector{
    boolean end();
    Object current();
    void next();
}
public class Practice3 {
    private ArrayList items ;
    public Practice3(){
        items = new ArrayList();
    }
    public void add(Object o){
        items.add(o);
    }
    private class Practice3Selector implements Selector{
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            i++;
        }
    }
    public Selector selector(){
        return new Practice3Selector();
    }
    public static void main(String[] args){
        Practice3 p = new Practice3();
        for(int i = 0; i <= 10; i++){
            p.add(i);
        }
        Selector s = p.selector();
        while(!s.end()){
            System.out.println(s.current());
            s.next();
        }
    }
}
