package com.lzc.corejava;

import com.sun.glass.ui.Size;
import org.omg.CORBA.IntHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

class Employee extends Person{
    public Employee(String name) {
        super(name);
    }

    public void f(){
        System.out.println("Employee's f()");
    }

    @Override
    public void getDescription() {
        System.out.println("employee"+this.getName());
    }
}
class Manager extends Employee{
    private boolean flag;

    public Manager(String name) {
        super(name);
    }

    public void f(){
        System.out.println("Manager's f()");
    }
    public void m(){
        System.out.println("Manager's m()");
    }
    public void change(){
        flag = true;
        System.out.println(flag);
    }
}
abstract class Person{
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Person(String name){
        this.name = name;
    }
    public abstract void getDescription();
}
class Students extends Person{

    public Students(String name) {
        super(name);
    }

    @Override
    public void getDescription() {
        System.out.println("student"+this.getName());
    }
}
enum SIZE{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
    private String abbreviation;
    private SIZE(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
}
public class Test {
    private  Integer m = 2;
    private  Integer i = 0;
    public static void main(String[] args){
        //printf("%d %s",new Object[]{1,"width"});
        int j;
        try {

            Class.forName("com.lzc.corejava.Manager").getConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void printf(String s,Object ... args){
        System.out.printf(s,args);
    }
    static void triple(IntHolder x){
        x.value = x.value*3;
    }
    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "m='" + m + '\'' +
                ", i=" + i +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return i == test.i &&
                Objects.equals(m, test.m);
    }

    @Override
    public int hashCode() {

        return Objects.hash(m, i);
    }
}
