package com.lzc.coreJava.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by POPO LIU on 2020-06-06.
 */
public class InnerClassTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.getClass());
        TalkingClock t = new TalkingClock(100, true);
        t.start(1,true);

        while(sc.hasNext()){
            if(sc.next().trim().equals("0")){
                break;
            }
        }
    }
}
class TalkingClock{
    private int interval;
    private boolean beep;
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }
    public void start(int i , boolean beep){
        class TimePrinter implements ActionListener {
            private static final String aa="1";
            public  void sss(){
                System.out.println(111);
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date()+i);
                if(beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        new TalkingClock(100,true){{
            System.out.println(100+22);
        }};
        if(beep) {
            Timer t = new Timer(interval, e->{

                    System.out.println("At the tone, the time is " + new Date()+i);
                    if(beep){
                        Toolkit.getDefaultToolkit().beep();
                    }

            });
            t.start();
        }
    }


}