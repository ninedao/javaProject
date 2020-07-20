package com.lzc.thinkingInJava.strings;

class WaterSource {
    private String s;
    public WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString() {
        return s;
    }
}

public class Practice1 {
    private String valve1, valve2, valve3, valve4;
    private WaterSource w = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("SprinklerSystem{");
        s.append("valve1='");
        s.append(valve1);
        s.append("', ");
        s.append("valve2='");
        s.append(valve2);
        s.append("', ");
        s.append("valve3='");
        s.append(valve3);
        s.append("', ");
        s.append("valve4='");
        s.append(valve4);
        s.append("', ");

        s.append("i='");
        s.append(i);
        s.append("', ");

        s.append("f='");
        s.append(f);
        s.append("', ");

        s.append("w=");
        s.append(w);
        s.append("}");
        return s.toString();
    }
    public static void main(String[] args){
        Practice1 p = new Practice1();
        System.out.println(p);
    }
}
