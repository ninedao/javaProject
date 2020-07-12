package com.lzc.thinkingInJava.exceptions;

public class Practice15 {
    static Switch sw = new Switch();
    public static void main(String[] args){
        try{
            sw.on();
            OnOffSwitch.f();
            throw new NullPointerException();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
        } finally {
            sw.off();
        }
    }
}
