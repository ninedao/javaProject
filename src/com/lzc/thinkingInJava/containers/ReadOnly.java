package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReadOnly {
    static Collection<String> data = new ArrayList<String>(Countries.names(10));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(data);
        System.out.println(c);
        //c.add("1");//java.lang.UnsupportedOperationException
    }
}
