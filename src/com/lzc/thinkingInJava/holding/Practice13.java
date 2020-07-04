package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.innerclasses.controller.Event;

import java.util.*;

public class Practice13 {
    private LinkedList<Event> events = new LinkedList<Event>();
    public void addEvent(Event event){
        events.add(event);
    }
    public void run(){
        LinkedList<Event> eventListCopy =
                new LinkedList<Event>(events);
        ListIterator<Event> it
                = eventListCopy.listIterator();
        while(it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
//    public static void main(String[] args){
//        List<Event> a = new ArrayList<Event>(Arrays.asList(new Event(10),new Event(10)));
//        System.out.println(a);
//        Iterator<Event> b = a.iterator();
//        while(b.hasNext()){
//            Event c = b.next();
//            b.remove();
//        }
//        System.out.println(a);
//    }
}
