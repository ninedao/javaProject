package com.lzc.thinkingInJava.generics;

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Gecko extends ComparablePet{
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
public class RestrictedComparablePet  {

}
