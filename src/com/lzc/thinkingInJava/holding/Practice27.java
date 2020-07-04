package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.*;
class Command{
    private String name;
    public Command(String name){
        this.name = name;
    }
    public void operation(){
        System.out.print(name);
    }
}
class Build{
    Queue<Command> makeQueue(){
        Queue<Command> queue = new LinkedList<Command>();
        for(int i = 0; i < 10; i++)
            queue.offer(new Command(i + " "));
        return queue;
    }
}
public class Practice27 {
    public static void commandEater(Queue<Command> qc) {
        while(qc.peek() != null){
            qc.remove().operation();
        }
    }
    public static void main(String[] args){
        Build b = new Build();
        commandEater(b.makeQueue());

    }
}
