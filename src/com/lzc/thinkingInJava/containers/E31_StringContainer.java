package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.CollectionData;
import com.lzc.thinkingInJava.util.CountingGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringContainer{
    private int index;
    private String[] array;
    private static final int INCR = 255;
    public StringContainer() {
        array = new String[10];
    }
    public StringContainer(int size) {
        array = new String[size];
    }
    public void add(String s){
        if(index >= array.length){
            String[] tmp = new String[array.length + INCR];
            for(int i = 0; i < array.length; i++){
                tmp[i] = array[i];
            }
            index = array.length;
            array = tmp;
        }
        array[index++] = s;
    }
    public String get(int i){
        return array[i];
    }
    public int size(){
        return index;
    }
}

public class E31_StringContainer {
    private static final int LOOPS= 10000;
    static List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
    static List<Test<StringContainer>> sTests = new ArrayList<Test<StringContainer>>();
    static{
        tests.add(new Test<List<String>>("addget") {
            @Override
            int test(List<String> container, TestParam tp) {
                for(int i = 0; i < LOOPS; i++){
                    container.add(String.valueOf(i));
                    container.get(i);
                }
                return 10000;
            }
        });
        sTests.add(new Test<StringContainer>("addget") {
            @Override
            int test(StringContainer container, TestParam tp) {
                for(int i = 0; i < LOOPS; i++){
                    container.add(String.valueOf(i));
                    container.get(i);
                }
                return 10000;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParam = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<String>(LOOPS), tests);
        Tester.run(new StringContainer(LOOPS), sTests);
    }
}
