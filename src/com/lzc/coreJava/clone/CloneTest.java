package com.lzc.coreJava.clone;

/**
 * Created by POPO LIU on 2020-06-03.
 */
public class CloneTest {
    public static void main(String[] args){
        try {
            Employee original = new Employee("John Q.public", 50000);
            original.setHireDay(2000,1,1);

            Employee copy = original.clone();
            copy.setHireDay(2020,12,31);
            copy.raiseSalary(10);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
