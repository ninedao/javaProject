package com.lzc.thinkingInJava.innerclasses.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {
    private List<Event> events = new ArrayList<Event>();
    public void addEvent(Event event){
        events.add(event);
    }
    public void run(){
        while(events.size() > 0){
//            Iterator<Event> it = events.iterator();
//            while(it.hasNext()){
//                Event e = it.next();
//                if(e.ready()){
//                    System.out.println(e);
//                    e.action();
//                    it.remove();
//                }
//            }
            for(Event e : new ArrayList<Event>(events)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}
