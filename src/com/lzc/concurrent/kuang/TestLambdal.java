package com.lzc.concurrent.kuang;

public class TestLambdal {
    static class Like2 implements ILike{
        @Override
        public void lambdal() {
            System.out.println("I Like Lambdal2");
        }
    }

    public static void main(String[] args) {
        class Like3 implements ILike{
            @Override
            public void lambdal() {
                System.out.println("I Like Lambdal3");
            }
        }
        ILike like = new Like();
        like.lambdal();
        like = new Like2();
        like.lambdal();
        like = new Like3();
        like.lambdal();
        like = new ILike() {
            @Override
            public void lambdal() {
                System.out.println("I Like Lambdal4");
            }
        };
        like.lambdal();
        like =()-> System.out.println("I Like Lambdal5");
        like.lambdal();
    }
}
interface ILike{
    void lambdal();
}
class Like implements ILike{
    @Override
    public void lambdal() {
        System.out.println("I Like Lambdal");
    }
}