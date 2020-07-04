package com.lzc.thinkingInJava.holding;

import java.lang.reflect.Array;
import java.util.*;

public class AddingGroups {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(moreInts);
        list.set(1, 1);
        // Arrays.asList()方法返回的ArrayList是其内部类,并没有重写父类AbstractList中add方法，调用add方法会抛出一个UnsupportedOperationExceptiony异常
        //list.add(1);

        System.out.println(Arrays.asList(moreInts).getClass().getName());
        System.out.println(collection.toString());
        Arrays.asList(moreInts).forEach((x)-> System.out.println(x));
    }
}
