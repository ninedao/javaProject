package com.lzc.thinkingInJava.generics;

abstract class GenericProcessor<T extends GenericProcessor<T>> {
    abstract T processor(T arg);
    T test(){
        return processor(null);
    }
}
class ConcreteProcessor extends GenericProcessor<ConcreteProcessor> {
    @Override
    ConcreteProcessor processor(ConcreteProcessor arg) {
        if(arg == null){
            return this;
        }
        return arg;
    }
}
public class E34_SelfBounded {
    public static void main(String[] args) {
        ConcreteProcessor concreteProcessor = new ConcreteProcessor();
        System.out.println(concreteProcessor == concreteProcessor.test());
    }
}
