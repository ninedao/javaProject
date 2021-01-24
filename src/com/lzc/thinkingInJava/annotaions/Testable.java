package com.lzc.thinkingInJava.annotaions;

import com.lzc.thinkingInJava.atunit.Test;

public class Testable {
    public void execute(){
        System.out.println("Executing..");
    }
    @Test
    void testExecute(){
        execute();
    }
}
