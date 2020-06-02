package com.lzc.coreJava.interfaces;

import java.util.Arrays;

/**
 * Created by POPO LIU on 2020-06-02.
 */
public class EmployeeSortTest {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Harry Hacker",35000);
        employees[1] = new Employee("Carl Cracker",75000);
        employees[2] = new Employee("Tony Tester",38000);
        Arrays.sort(employees);
        for(Employee e : employees){
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
