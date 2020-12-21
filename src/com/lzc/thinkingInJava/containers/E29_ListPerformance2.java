package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.CollectionData;
import com.lzc.thinkingInJava.util.CountingGenerator;
import com.lzc.thinkingInJava.util.Generated;
import com.lzc.thinkingInJava.util.Generator;

import java.util.*;

public class E29_ListPerformance2 {
    static CountingGenerator.String gen = new CountingGenerator.String();
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
    static List<Test<LinkedList<String>>> qtests = new ArrayList<Test<LinkedList<String>>>();
    static {
        tests.add(new Test<List<String>>("add") {
            @Override
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();
                    for(int j = 0; j < listSize; j++){
                        list.add(gen.next());
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            @Override
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++){
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            @Override
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++){
                    list.set(rand.nextInt(listSize), "47");
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            @Override
            int test(List<String> list, TestParam tp) {
                final int loops = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for(int i = 0; i < loops; i++){
                    it.add("47");
                }
                return loops;
            }
        });

        tests.add(new Test<List<String>>("insert") {
            @Override
            int test(List<String> list, TestParam tp) {
                final int loops = tp.loops;
                for(int i = 0; i < loops; i++){
                    list.add(5,"47");
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            @Override
            int test(List<String> list, TestParam tp) {
                final int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while(list.size() > 5) {
                        list.remove(5);
                    }
                }
                return loops * size;
            }
        });
        qtests.add(new Test<LinkedList<String>>("addFirst") {
            @Override
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();;
                    for(int j = 0; j < size; j++){
                        list.addFirst("47");
                    }
                }
                return loops * size;
            }
        });
        qtests.add(new Test<LinkedList<String>>("addLast") {
            @Override
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();;
                    for(int j = 0; j < size; j++){
                        list.addLast("47");
                    }
                }
                return loops * size;
            }
        });
        qtests.add(new Test<LinkedList<String>>("rmFirst") {
            @Override
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while(list.size() > 0){
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qtests.add(new Test<LinkedList<String>>("rmLast") {
            @Override
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while(list.size() > 0){
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<String>> {

        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<String> initalize(int size) {
            container.clear();
            container.addAll(CollectionData.list(new CountingGenerator.String(), size));
            return container;
        }
        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }
    public static void main(String[] args) {
        if(args.length > 0){
            Tester.defaultParam = TestParam.array(args);
        }
        Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1,3)){
            @Override
            protected List<String> initalize(int szie) {
                String[] ia = Generated.array(String.class, new CountingGenerator.String(), szie);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParam = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if(args.length > 0){
            Tester.defaultParam = TestParam.array(args);
        }
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(), tests);
        ListTester.run(new Vector<String>(), tests);
        Tester.fieldWidth = 12;

        Tester<LinkedList<String>> qTest = new Tester<LinkedList<String>>(new LinkedList<String>(), qtests);
        qTest.setHeadline("Queue tests");

        qTest.timedTest();
    }
}
