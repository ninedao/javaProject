package com.lzc.thinkingInJava.holding;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue){
        while(queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for(int i = 0; i< 10; i++){
            queue.add(rand.nextInt(10 + i));
        }
        System.out.println(queue);
        Queue<Character> cQueue = new LinkedList<Character>();
        for(Character e : "dfasdfa".toCharArray()){
            cQueue.offer(e);
        }
        System.out.println(cQueue);
    }
}
