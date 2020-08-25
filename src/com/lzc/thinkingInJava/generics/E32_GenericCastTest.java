package com.lzc.thinkingInJava.generics;


//超出应该报Fullstackexception 或者EmptystackException 而不是ArrayIndexOutOfBoundsException,所以还是有必要进行边界检查
public class E32_GenericCastTest {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<Integer> fixedSizeStack = new FixedSizeStack<Integer>(1);
        fixedSizeStack.push(1);
        System.out.println(fixedSizeStack.pop());
        try{
            fixedSizeStack.pop();
        } catch (Exception e) {
            System.out.println(e);
        }
        fixedSizeStack = new FixedSizeStack<Integer>(1);
        fixedSizeStack.push(2);
        try{
            fixedSizeStack.push(2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
