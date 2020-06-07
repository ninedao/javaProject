package com.lzc.coreJava.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by POPO LIU on 2020-06-03.
 */
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDate;
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.hireDate = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();
        cloned.hireDate = (Date)hireDate.clone();
        return cloned;
    }
    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDate.setTime(newHireDay.getTime());
    }
    public void raiseSalary(double byPercent){
        double rise = this.salary * byPercent / 100;
        salary += rise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
