package com.lzc.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class E29_WildcardTest {
    static void f1(Holder<List<?>> holder) {
        List<?> l = holder.get();
        System.out.println(holder.equals(l));
        //Error
        //l.add(2);
        //l.add(new Object());
        Integer i = (Integer) l.get(0);
        System.out.println(i);
        System.out.println(l.contains(i));
        System.out.println(l.remove(i));
        holder.set(new ArrayList<Double>());
    }
    static void f2(List<Holder<?>> holder) {
        Holder<?> holder1 = holder.get(0);
        System.out.println(holder1.equals(Integer.valueOf(1)));
        //holder.set(2);
        System.out.println(holder1.get());
        holder.add(new Holder<Double>(1.0));
        System.out.println(holder.get(1).get());
        holder.remove(0);
        System.out.println(holder.size());
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        f1(new Holder<List<?>>(l));
        List<Holder<?>> list2 = new ArrayList<Holder<?>>();
        list2.add(new Holder<Integer>(1));
        f2(list2);

    }
}
