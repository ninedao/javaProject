package com.lzc.thinkingInJava.enumerated.menu;

import com.lzc.thinkingInJava.util.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    MAINCOURSE(Food.MainCourse.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
