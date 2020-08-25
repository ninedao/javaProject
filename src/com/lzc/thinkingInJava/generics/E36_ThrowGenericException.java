package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface E36_Processor<T, E extends Exception, F extends Exception> {
    void process(List<T> resultCollector) throws E, F;
}

class E36_ProcessRunner<T, E extends Exception, F extends Exception> extends ArrayList<E36_Processor<T, E, F>> {
    List<T> processAll() throws Exception {
        List<T> resultCollector = new ArrayList<T>();
        for(E36_Processor processor : this){
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class E36_Failure1 extends Exception{}
class E36_Failure2 extends Exception{}
class E36_Processor1 implements E36_Processor<String, E36_Failure1, E36_Failure2> {
    static Random rand = new Random(47);
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws E36_Failure1, E36_Failure2 {
        if(count-- > 1){
            resultCollector.add("Hep!");
        }else{
            resultCollector.add("Ho!");
        }
        if(count < 0){
            if(rand.nextBoolean()){
                throw new E36_Failure1();
            }
            throw new E36_Failure2();
        }
    }
}

class E36_Failure3 extends Exception{}
class E36_Failure4 extends Exception{}

class E36_Processor2 implements E36_Processor<Integer, E36_Failure3, E36_Failure4> {
    static Random rand = new Random(47);
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws E36_Failure3, E36_Failure4 {
        if(count-- == 1){
            resultCollector.add(47);
        }else{
            resultCollector.add(11);
        }
        if(count < 0){
            if(rand.nextBoolean()){
                throw new E36_Failure3();
            }
            throw new E36_Failure4();
        }
    }
}

public class E36_ThrowGenericException {
    public static void main(String[] args) {
        E36_ProcessRunner<String, E36_Failure1, E36_Failure2> processors = new E36_ProcessRunner<String, E36_Failure1, E36_Failure2>();
        for(int i = 0; i < 3; i++) {
            processors.add(new E36_Processor1());
        }
        try {
            System.out.println(processors.processAll());
        } catch (Exception e) {
            System.out.println(e);
        }

        E36_ProcessRunner<Integer, E36_Failure3, E36_Failure4> processors2 = new E36_ProcessRunner<Integer, E36_Failure3, E36_Failure4>();
        for(int i = 0; i < 3; i++) {
            processors2.add(new E36_Processor2());
        }
        try {
            System.out.println(processors2.processAll());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
