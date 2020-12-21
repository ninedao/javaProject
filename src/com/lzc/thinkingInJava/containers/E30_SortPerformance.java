package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.CollectionData;
import com.lzc.thinkingInJava.util.CountingGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class E30_SortPerformance {
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static{
        tests.add(new Test<List<Integer>>("compare") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                for(int i = 0; i < tp.loops; i++){
                    container.clear();
                    container.addAll(CollectionData.list(new CountingGenerator.Integer(), tp.size));
                    Collections.sort(container);
                }
                return tp.loops;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>> {

        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<Integer> initalize(int size) {
            container.clear();
            container.addAll(CollectionData.list(new CountingGenerator.Integer(), size));
            return container;
        }
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new E30_SortPerformance.ListTester(list, tests).timedTest();
        }

    }

    public static void main(String[] args) {
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
    }
}
