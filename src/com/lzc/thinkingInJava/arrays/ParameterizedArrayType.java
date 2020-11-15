package com.lzc.thinkingInJava.arrays;

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}
class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        Integer[] integers = new ClassParameter<Integer>().f(ints);
        Double[] doubles1 = new ClassParameter<Double>().f(doubles);
        integers = MethodParameter.f(ints);
        doubles1 = MethodParameter.f(doubles);
    }

}
