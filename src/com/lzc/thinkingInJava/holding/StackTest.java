package com.lzc.thinkingInJava.holding;


import com.lzc.thinkingInJava.util.Stack;

public class StackTest {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        for(String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
