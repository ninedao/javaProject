package com.lzc.thinkingInJava.reusing;

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
public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource w = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "valve1='" + valve1 + '\'' +
                ", valve2='" + valve2 + '\'' +
                ", valve3='" + valve3 + '\'' +
                ", valve4='" + valve4 + '\'' +
                ", w=" + w +
                ", i=" + i +
                ", f=" + f +
                '}';
    }
    public static void main(String[] args){
        SprinklerSystem s = new SprinklerSystem();
        System.out.println(s);
    }
}
