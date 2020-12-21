package com.lzc.thinkingInJava.containers;

public class RandomBounds {
    static void usage(){
        System.out.println("Usage:");
        System.out.println("\tRandomBounds lower");
        System.out.println("\tRandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args) {
        args = new String[]{"lower"};
        if(args.length != 1){
            usage();
        }
        if(args[0].equals("lower")){
//            while(Math.random() != 0.0){
//                ;
//            }
            double i = 0.0;
            do{
                i = Math.random();
                System.out.println(i);
            }while(Math.random() != 0.0);
            System.out.println("Producted 0.0!");
        }
        if(args[0].equals("upper")){
            while(Math.random() != 1.0){
                ;
            }
            System.out.println("Producted 1.0!");
        }
    }
}
