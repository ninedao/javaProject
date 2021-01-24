package com.lzc.thinkingInJava.enumerated;

public interface Competiter<T extends Competiter<T>> {
    Outcome compete(T it);
}
