package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static com.lzc.thinkingInJava.generics.watercolors.Watercolors.*;
import static com.lzc.thinkingInJava.generics.watercolors.Watercolors.BURNT_UMBER;

public class E17_Sets2 {
    public static <T> Set<T> copy(Set<T> a){
        if(a instanceof EnumSet) {
            return ((EnumSet)a).clone();
        }
        return new HashSet<T>(a);
    }
    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
    public static void main(String[] args) {
        Set<Watercolors> set1 = copy(EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE));
        Set<Watercolors> set2 = copy(EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER));
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + difference(set1, subset));
        System.out.println("difference(set2, subset): " + difference(set2, subset));
        System.out.println("complement(set1, set2): " + complement(set1, set2));
    }
}
