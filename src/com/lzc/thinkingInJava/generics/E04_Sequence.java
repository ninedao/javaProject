package com.lzc.thinkingInJava.generics;
interface Selector<T>{
    boolean end();
    Object current();
    void next();
}

public class E04_Sequence<T> {
    private Object[] items;
    private int next = 0;
    public E04_Sequence(int size){
        items = new Object[size];
    }
    public void add(T x){
        if(next < items.length){
            items[next++] = x;
        }
    }
    public class SequenceSelect implements Selector<T> {
        private int i = 0;
        @Override
        public boolean end() {
            return i == next;
        }

        @Override
        public T current() {
            return (T) items[i];
        }

        @Override
        public void next() {
            if(i < next){
                i++;
            }
        }
    }
    public Selector<T> selector(){
        return new SequenceSelect();
    }
    public static void main(String[] args){
        E04_Sequence sequence = new E04_Sequence(10);
        for(int i = 0; i< 5; i++){
            sequence.add(i);
        }
        Selector<Integer> sequenceSelect = sequence.selector();
        while(!sequenceSelect.end()) {
            System.out.print(sequenceSelect.current() + " ");
            sequenceSelect.next();
        }
        System.out.println();
        sequence.add(Integer.toString(10));
    }
}
