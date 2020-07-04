package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test{
    private static long counter = 0;
    private final long id = counter++;
    public long id(){
        return id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}
public class Practice7 {
    public static void main(String[] args) {
        Test[] t =new Test[10];
        for(int i = 0; i < 10; i++) {
            t[i] = new Test();
        }
        List<Test> list = new ArrayList<Test>(Arrays.asList(t));
        System.out.println(list);
        List<Test> sub = list.subList(2, 5);
        System.out.println(sub);
        list.removeAll(sub);
        System.out.println(list);
    }
}
