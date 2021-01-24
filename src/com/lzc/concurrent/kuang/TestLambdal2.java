package com.lzc.concurrent.kuang;

public class TestLambdal2 {


    public static void main(String[] args) {

        ILove i = (x,y)-> System.out.println("I LOVE YOU" + x+y);
        i.lambdal(1,2);
    }
}

interface ILove{
    void lambdal(int a, int b);
}
