package com.lzc.thinkingInJava.annotaions.databases;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
