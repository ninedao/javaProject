package com.lzc.thinkingInJava.generics;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.Arrays;
import java.util.List;

final class DataManipulator1 implements Comparable<DataManipulator1> {
    private int value;
    public DataManipulator1(int value) {
        this.value = value;
    }
    public void increment(){
        ++value;
    }
    public int getValue(){
        return value;
    }
    @Override
    public int compareTo(DataManipulator1 o) {
        return Integer.valueOf(value).compareTo(o.value);
    }
    public String toString() {
        return Integer.toString(value);
    }
}
final class DataManipulator2{
    private String value;
    public DataManipulator2(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
public class E42_Functional {
    static class Increamentor implements UnaryFunction<DataManipulator1, DataManipulator1> {
        public DataManipulator1 function(DataManipulator1 dataManipulator1){
            dataManipulator1.increment();
            return dataManipulator1;
        }
    }
    static class UpperCaseConverter implements UnaryFunction<String, DataManipulator2> {
        @Override
        public String function(DataManipulator2 x) {
            return x.getValue().toUpperCase();
        }
    }
    static class Concatenator implements Combiner<DataManipulator2> {

        @Override
        public DataManipulator2 combine(DataManipulator2 x, DataManipulator2 y) {
            x.setValue(x.getValue() + y.getValue());
            return x;
        }
    }
    public static void main(String[] args) {
        DataManipulator1 rf = new DataManipulator1(4);
        List<DataManipulator1> ldml = Arrays.asList(
                new DataManipulator1(3), new DataManipulator1(10),
                new DataManipulator1(1), new DataManipulator1(7)
        );
        System.out.println(
                Functional.transForm(
                        Functional.filter(ldml, new Functional.GreaterThan<DataManipulator1>(rf)), new Increamentor()
                )
        );
        List<DataManipulator2> ldm2 = Arrays.asList(
                new DataManipulator2("a"), new DataManipulator2("B"),
                new DataManipulator2("c"), new DataManipulator2("d")
        );
        System.out.println(
                Functional.transForm(ldm2, new UpperCaseConverter())
        );
        System.out.println(Functional.reduce(ldm2, new Concatenator()).getValue());
    }
}
