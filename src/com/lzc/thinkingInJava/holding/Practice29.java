package com.lzc.thinkingInJava.holding;

import java.util.PriorityQueue;
import java.util.Random;

class Simple extends Object{}
public class Practice29 {

    public static void main(String[] args){

        PriorityQueue<Simple> queue = new PriorityQueue<Simple>();
        for(int i = 0; i < 10; i++){
            queue.offer(new Simple());
        }
        while(queue.peek() !=null){
            System.out.print(queue.poll());
        }
    }
}
