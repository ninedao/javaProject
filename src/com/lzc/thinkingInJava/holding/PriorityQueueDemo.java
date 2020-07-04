package com.lzc.thinkingInJava.holding;

import java.util.*;

public class PriorityQueueDemo {
    private static PriorityQueueDemo m = new PriorityQueueDemo();
    public static void main(String[] args){
        PriorityQueueDemo p = new PriorityQueueDemo();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++){
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);
        List<Integer> list = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(list);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(list.size(), Collections.reverseOrder());
        priorityQueue.addAll(list);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPriorityQueue);
        stringPriorityQueue = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        QueueDemo.printQ(stringPriorityQueue);

        Set<Character> set = new HashSet<Character>();
        for(Character e : fact.toCharArray()){
            set.add(e);
        }
        PriorityQueue<Character> characterPriorityQueue = new PriorityQueue<Character>(set);
        QueueDemo.printQ(characterPriorityQueue);
    }
}
