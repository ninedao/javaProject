package com.lzc.thinkingInJava.util;

import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> linkedList = new LinkedList<T>();
    public void  addFirst(T t) {
        linkedList.addFirst(t);
    }
    public void  addLast(T t) {
        linkedList.addLast(t);
    }
    public T getFirst() {
        return linkedList.getFirst();
    }
    public T getLast(){
        return linkedList.getLast();
    }
    public T removeFirst(){
        return linkedList.removeFirst();
    }
    public T removeLast(){
        return linkedList.removeLast();
    }
    public int size(){
        return linkedList.size();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
