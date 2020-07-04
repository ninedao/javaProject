package com.lzc.thinkingInJava.holding;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class Practice28 {

    public static void main(String[] args){
        Random rand = new Random(47);
        PriorityQueue<Double> queue = new PriorityQueue<Double>();
        for(int i = 0; i < 10; i++){
            queue.offer(rand.nextDouble());
        }
        while(queue.peek() !=null){
            System.out.print(queue.poll());
        }
    }
}
