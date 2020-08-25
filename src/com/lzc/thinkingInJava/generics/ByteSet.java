package com.lzc.thinkingInJava.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ByteSet {
    Byte[] possible = {1, 2, 3, 4, 5, 6};
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possible));
    //Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList(1, 2, 3, 4, 5, 6));
    public static void main(String[] args) {
        ByteSet m = new ByteSet();
    }
}
