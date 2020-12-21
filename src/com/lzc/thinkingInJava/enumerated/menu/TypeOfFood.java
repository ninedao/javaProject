package com.lzc.thinkingInJava.enumerated.menu;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.BURRITO;
        food = Food.Coffee.CAPPUCCINO;
        food = Food.Dessert.CREME_CARAMEL;
    }
}
