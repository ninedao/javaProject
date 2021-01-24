package com.lzc.thinkingInJava.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public int next() {
        return atomicInteger.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
