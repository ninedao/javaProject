package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}
class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws Exception {
        List<T> resultCollector = new ArrayList<T>();
        for(Processor processor : this){
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}
class Failure1 extends Exception{}
class Processor1 implements Processor<String, Failure1> {
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if(count-- > 1){
            resultCollector.add("Hep!");
        }else{
            resultCollector.add("Ho!");
        }
        if(count < 0){
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception{}
class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 1){
            resultCollector.add(47);
        }else{
            resultCollector.add(11);
        }
        if(count < 0){
            throw new Failure2();
        }
    }
}
public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> processors = new ProcessRunner<String, Failure1>();
        for(int i = 0; i < 3; i++) {
            processors.add(new Processor1());
        }
        try {
            System.out.println(processors.processAll());
        } catch (Exception e) {
            System.out.println(e);
        }

        ProcessRunner<Integer, Failure2> processors2 = new ProcessRunner<Integer, Failure2>();
        for(int i = 0; i < 3; i++) {
            processors2.add(new Processor2());
        }
        try {
            System.out.println(processors2.processAll());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
