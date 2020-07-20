package com.lzc.thinkingInJava.strings;

import java.math.BigInteger;
import java.util.Formatter;

public class Practice6 {
    private int a1;
    private long a2;
    private float a3;
    private double a4;
    public Practice6(int a1, long a2, float a3, double a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }
    @Override
    public String toString() {
        return String.format("Practice6{ a1= %d, a2=%d,a3=%g, a4=%g }",a1, a2, a3, a4);
    }
    public static void main(String[] args) {
        Practice6 x = new Practice6(2, 45l, 1.2f, 2.7182818289);
        Practice6 ex = new Practice6(-2147483648, -9223372036854775808L, 1.1754943508222875E-38f, 2.2250738585072014E-308);
        Practice6 exMax = new Practice6(2147483647, 9223372036854775807L, 3.4028234663852886E38f, 1.7976931348623157E308);
        System.out.println(x);
        System.out.println(ex);
        System.out.println(exMax);
    }
}
