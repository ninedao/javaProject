package com.lzc.coreJava.timer;

import com.lzc.coreJava.interfaces.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by POPO LIU on 2020-06-03.
 */
class TimerPrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
public class TimerTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        TimerPrinter test = new TimerPrinter();
        Timer t = new Timer(1000,test);
        t.start();
        JOptionPane.showConfirmDialog(null, "Quit program?");
        System.exit(0);
    }
}
