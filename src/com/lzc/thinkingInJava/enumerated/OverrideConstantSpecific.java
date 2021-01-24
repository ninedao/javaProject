package com.lzc.thinkingInJava.enumerated;

public enum OverrideConstantSpecific {
    NUT,BOLT,WASHER{
        @Override
        void f() {
            System.out.println("WASHER.f()");
        }
    };
    void f(){
        System.out.println("default.f");
    }

    public static void main(String[] args) {
        for(OverrideConstantSpecific o : OverrideConstantSpecific.values()) {
            o.f();
        }
    }
}
