package com.lzc.thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;

class IntContainer{
    private int index;
    private int[] array;
    private static final int INCR = 255;
    public IntContainer() {
        array = new int[10];
    }
    public IntContainer(int size) {
        array = new int[size];
    }
    public void add(int s){
        if(index >= array.length){
            int[] tmp = new int[array.length + INCR];
            for(int i = 0; i < array.length; i++){
                tmp[i] = array[i];
            }
            index = array.length;
            array = tmp;
        }
        array[index++] = s;
    }
    public int get(int i){
        return array[i];
    }
    public void set(int i, int val) {
        array[i] = val;
    }
    public int size(){
        return index;
    }
}
public class E32_IntContainer {
    private static final int LOOPS= 10000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static List<Test<IntContainer>> sTests = new ArrayList<Test<IntContainer>>();
    static{
        tests.add(new Test<List<Integer>>("addget") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                for(int i = 0; i < LOOPS; i++){
                    container.add(i);
                    container.set(i, container.get(i) + 1);
                }
                return 10000;
            }
        });
        sTests.add(new Test<IntContainer>("addget") {
            @Override
            int test(IntContainer container, TestParam tp) {
                for(int i = 0; i < LOOPS; i++){
                    container.add(i);
                    container.set(i, container.get(i) + 1);
                }
                return 10000;
            }
        });
    }
    public static void main(String[] args) {
        Tester.defaultParam = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<Integer>(LOOPS), tests);
        Tester.run(new IntContainer(LOOPS), sTests);
    }
}
