package com.lzc.thinkingInJava.exceptions;
interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Practice12 {
    private Object[] items;
    private int next = 0;
    public Practice12(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public class SequenceSelect implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == next;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i < next){
                i++;
            }
        }
    }
    public static void main(String[] args){
        Practice12 sequence = new Practice12(10);
        for(int i = 0; i< 5; i++){
            sequence.add(i);
        }
        SequenceSelect sequenceSelect = sequence.new SequenceSelect();
        while(!sequenceSelect.end()) {
            System.out.print(sequenceSelect.current() + " ");
            sequenceSelect.next();
        }
        System.out.println();
        sequence.add(Integer.toString(10));
    }
}
