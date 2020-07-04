package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.*;

import java.util.*;

import static com.lzc.thinkingInJava.util.Print.print;

public class Practice5 {
    public static List<Integer> listOfRangdInteger(int length, int n){
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < length; i++){
            list.add(rand.nextInt(n));
        }
        return list;
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        List<Integer> integers = listOfRangdInteger(7, 10);
        print("1: " + integers);
        Integer h = 7;
        integers.add(h);
        print("2: " + integers);
        print("3: " + integers.contains(h));
        integers.remove(h);
        Integer p = integers.get(2);
        print("4: " + p + " " + integers.indexOf(p));
        Integer cymric = new Integer(rand.nextInt(10));
        print("5: " + integers.indexOf(cymric));
        print("6: " + integers.remove(cymric));
        print("7: " + integers.remove(p));
        print("8: " + integers);
        integers.add(3, 3);
        print("9: " + integers);
        List<Integer> sub = integers.subList(1,4);
        print("subList: " + sub);
        print("10: " + integers.containsAll(sub));
        Collections.sort(sub);
        print("sorted subList: " + sub);
        print("11: " + integers.containsAll(sub));
        Collections.shuffle(sub, rand);
        print("shuffled subList: " + sub);
        print("12: " + integers.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(integers);
        sub = Arrays.asList(integers.get(1), integers.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<Integer>(integers);
        copy.remove(2);
        print("14: " + copy);
        copy.retainAll(sub);
        print("15: " + copy);
        copy.set(1, 1);
        print("16: " + copy);
        copy.addAll(2, sub);
        print("17: " + copy);
        print("18: " + integers.isEmpty());
        integers.clear();
        print("19: " + integers);
        print("20: " + integers.isEmpty());
        integers.addAll(listOfRangdInteger(4, 10));
        print("21: " + integers);
        Object[] o = integers.toArray();
        print("22: " + o[3]);
        Integer[] pa = integers.toArray(new Integer[0]);
        print("23: " + pa[3]);
    }
}
