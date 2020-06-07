package com.lzc.coreJava.interfaces;

import javax.swing.*;

/**
 * Created by POPO LIU on 2020-06-02.
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void raiseSalary(double byPercent){
        double rise = this.salary * byPercent / 100;
        salary += rise;
    }
    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }
}
