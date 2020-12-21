package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.innerclasses.controller.Event;
import com.lzc.thinkingInJava.innerclasses.controller.GreenhouseControls;
import com.lzc.thinkingInJava.innerclasses.controller.GreenhouseControls.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class GreenHouseControls2 extends GreenhouseControls {
    class Restart extends Event {
        private Event[] events;
        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            for(Event e : events){
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting System";
        }

        public void setEvents(Event[] events) {
            this.events = events;
        }
    }
    @SuppressWarnings("unchecked")
    class GHEEventFactory{
        LinkedList<EventCreator> events = new LinkedList<EventCreator>();
        class EventCreator{
            long offset;
            Constructor<Event> ctor;
            public EventCreator(long offset, Constructor<Event> constructor){
                this.offset = offset;
                this.ctor = constructor;
            }
        }
        public GHEEventFactory(String eventFile) {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(eventFile));
                String s;
                while((s = bf.readLine()) != null) {
                    int colon = s.indexOf(":");
                    String className = s.substring(0, colon).trim();
                    // 内部类类名为[外部类名$内部类名]
                    Class<?> outer = className.equals("Restart") ? GreenHouseControls2.class : GreenhouseControls.class;
                    String type = outer.getName() + "$" + className;
                    long offset = Long.parseLong(s.substring(colon + 1).trim());
                    Class<Event> eventClass = (Class<Event>) Class.forName(type);
                    // 非静态内部类创建方法要有外部类，所以构造参数是两个，多重内部类可能有多个
                    //上面那句话的验证 System.out.println(eventClass.getConstructors()[0]);
                    Constructor<Event> ctor = eventClass.getConstructor(new Class<?>[]{outer, long.class});
                    events.add(new EventCreator(offset, ctor));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Iterator<Event> iterator(){
            return new Iterator<Event>() {
                Iterator<EventCreator> it = events.iterator();
                @Override
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override
                public Event next() {
                    EventCreator ec = it.next();
                    Event returnVal = null;
                    try {
                        returnVal = ec.ctor.newInstance(new Object[]{GreenHouseControls2.this, ec.offset});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return returnVal;
                }
            };
        }
    }
    GHEEventFactory gheEventFactory;
    public GreenHouseControls2(String initFile) {
        gheEventFactory = new GHEEventFactory(initFile);
        LinkedList<Event> reatartableEvents = new LinkedList<Event>();
        Iterator<Event> it = gheEventFactory.iterator();
        while(it.hasNext()){
            Event e = it.next();
            if(e instanceof Bell || e instanceof Restart) {
                continue;
            }
            reatartableEvents.add(e);
        }
        it = gheEventFactory.iterator();
        while(it.hasNext()){
            Event e = it.next();
            addEvent(e);
            if(e instanceof  Restart) {
                ((Restart)e).setEvents(reatartableEvents.toArray(new Event[0]));
            }
        }
    }
}
public class E11_GreenHouseControls2 {
    public static void main(String[] args) throws NoSuchMethodException {
        GreenHouseControls2 gc = new GreenHouseControls2("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\io\\GreenhouseConfig.dat");
        gc.addEvent(new GreenhouseControls.Terminate(10000000));
        gc.run();
    }
}
