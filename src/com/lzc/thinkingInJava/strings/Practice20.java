package com.lzc.thinkingInJava.strings;




import java.util.Scanner;

public class Practice20 {
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;

    public Practice20(String m) {
        Scanner s = new Scanner(m);

        this.i = s.nextInt();
        this.l = s.nextLong();
        this.f = s.nextFloat();
        this.d = s.nextDouble();
        this.s = s.next();
    }

    @Override
    public String toString() {
        return "Practice20{" +
                "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args){
        Practice20 p = new Practice20("1 111111111 1.0 1.567819343 abcdefg hijk");
        System.out.println(p.toString());
    }
}
