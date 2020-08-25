package com.lzc.thinkingInJava.generics;

public class E30_PrimitiveHolderTest {
    public static void main(String[] args) {
        Holder<Byte> byteHolder = new Holder<Byte>();
        byteHolder.set((byte)1);
        byte b = byteHolder.get();
        System.out.println(b == (byte)1);

        Holder<Short> shortHolder = new Holder<Short>();
        shortHolder.set((short) 1);
        short s = shortHolder.get();
        System.out.println(s == 1);

        Holder<Integer> intHolder = new Holder<Integer>();
        intHolder.set(1);
        int i = intHolder.get();
        System.out.println(i == 1);

        Holder<Long> longHolder = new Holder<Long>();
        longHolder.set((long)111111111);
        long l = intHolder.get();
        System.out.println(l == 111111111);

        Holder<Double> doubleHolder = new Holder<Double>();
        doubleHolder.set(1.7);
        double j = doubleHolder.get();
        System.out.println(j == 1.7);

        Holder<Float> floatHolder = new Holder<Float>();
        floatHolder.set(1.7f);
        float k = floatHolder.get();
        System.out.println(k == 1.7f);

        Holder<Character> charHolder = new Holder<Character>();
        charHolder.set('c');
        char c = charHolder.get();
        System.out.println(c == 'c');

        Holder<Boolean> booleanHolder = new Holder<Boolean>();
        booleanHolder.set(true);
        boolean bb = booleanHolder.get();
        System.out.println(bb);
    }
}
