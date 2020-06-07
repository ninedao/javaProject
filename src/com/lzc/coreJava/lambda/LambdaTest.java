package com.lzc.coreJava.lambda;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by POPO LIU on 2020-06-04.
 */
class Greeter {
    public  void greet(ActionEvent e){
        System.out.println("Hello World!");
    }
}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
@FunctionalInterface
interface test{
    void tt();
}
public class LambdaTest extends Greeter {
    public void greet() {
        Timer t = new Timer(1000, this::greet);
        t.start();
    }
    public static void repeatMessage(String text, int delay){
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay,listener).start();
    }
    public int sub(String i, String j){
        return i.length() - j.length();
    }
    public static void main(String[] args){
        LambdaTest a = new LambdaTest();
        repeatMessage("Hello",1000);//闭包，函数调用外部函数的参数或变量(不可改变值)，即使外部函数的生命周期终结
        new LambdaTest().greet();
        String[] planets = {"tes","abc","bed","acd","fff","tt","s","yu","hyfd"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets, a::sub);//lambda表达式
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets, String::compareToIgnoreCase);// 方法引用 类::方法
        System.out.println(Arrays.toString(planets));
        //Timer t = new Timer(1000, e-> System.out.println("The time is " + LocalTime.now().toString()));
        Timer t = new Timer(1000, System.out::println); // 方法引用 实例::方法
        t.start();
        //JOptionPane.showConfirmDialog(null,"exit?");
        List<String> s = new ArrayList<String>();
        s.add("zvd");
        s.add("1");
        s.add(null);
        s.add("thd");


        Stream<Person>stream = s.stream().map(Person::new); //构造器引用
        s.removeIf(e->{
           return (e == null) || "1".equals(e);
        });
        System.out.println(s.toString());
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            if(sc.next().equals("0")){
                break;
            }
        }
    }
}
