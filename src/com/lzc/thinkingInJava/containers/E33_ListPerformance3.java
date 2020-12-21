package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.CollectionData;
import com.lzc.thinkingInJava.util.CountingIntegerList;

import java.util.*;

class FastTraversalLinkedList<T> extends AbstractList<T> {
    private class FlaggedArrayList {
        private FlaggedLinkedList companion;
        boolean changed = false;
        private ArrayList<T> list = new ArrayList<T>();
        public void addCompanion(FlaggedLinkedList companion) {
            this.companion = companion;
        }
        private void synchronize(){
            if(companion.changed){
                list = new ArrayList<T>(companion.list);
                companion.changed = false;
            }
        }
        public T get(int index){
            synchronize();
            return list.get(index);
        }
        public T remove(int index){
            synchronize();
            changed = true;
            return list.remove(index);
        }
        public int size(){
            synchronize();
            return list.size();
        }
        public boolean remove(Object item){
            synchronize();
            changed = true;
            return list.remove(item);
        }
        public void clear(){
            list.clear();
            changed = false;
        }
        public Iterator<T> iterator(){
            synchronize();
            return list.iterator();
        }
    }
    private class FlaggedLinkedList{
        private FlaggedArrayList companion;
        boolean changed = false;
        private LinkedList<T> list = new LinkedList<T>();
        public void addCompanion(FlaggedArrayList companion) {
            this.companion = companion;
        }
        private void synchronize(){
            if(companion.changed){
                list = new LinkedList<T>(companion.list);
                companion.changed = false;
            }
        }
        public void add(int index, T item){
            synchronize();
            changed = true;
            list.add(index, item);
        }
        public boolean add(T item){
            synchronize();
            changed = true;
            return list.add(item);
        }
        public Iterator<T> iterator(){
            synchronize();
            return list.iterator();
        }
        public void clear(){
            list.clear();;
            changed = false;
        }
    }
    private FlaggedArrayList arrayList = new FlaggedArrayList();
    private FlaggedLinkedList linkedList = new FlaggedLinkedList();
    {
        arrayList.addCompanion(linkedList);
        linkedList.addCompanion(arrayList);
    }
    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public int size() {
        return arrayList.size();
    }
    public void add(int index, T item){
        linkedList.add(index, item);
    }
    public boolean add(T item) {
        return linkedList.add(item);
    }
    public T remove(int index) {
        return arrayList.remove(index);
    }
    public boolean remove(Object item){
        return arrayList.remove(item);
    }
    public Iterator<T> iterator(){
        return arrayList.iterator();
    }
    public void clear(){
        linkedList.clear();
        arrayList.clear();
    }
}
public class E33_ListPerformance3 {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static {
        tests.add(new Test<List<Integer>>("iter") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                for(int i = 0; i < tp.loops; i++){
                    Iterator<Integer> it = container.iterator();
                    while(it.hasNext()){
                        it.next();
                    }
                }
                return tp.loops;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = container.size();
                for(int i = 0; i < loops; i++){
                    container.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++){
                    container.add(5, 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove_I") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int count = 0;
                for(int i = container.size() / 2; i < container.size(); i++){
                    ++count;
                    container.remove(i);
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("remove_O") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int count = 0;
                for(int i = container.size() / 2; i < container.size(); i++){
                    ++count;
                    container.remove(container.get(i));
                }
                return count;
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
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        public static void run(List<Integer> cntnr, List<Test<List<Integer>>> tests) {
            new ListTester(cntnr, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
    }
}
