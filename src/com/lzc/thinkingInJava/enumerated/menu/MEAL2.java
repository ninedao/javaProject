package com.lzc.thinkingInJava.enumerated.menu;

import com.lzc.thinkingInJava.enumerated.SecurityCategory;
import com.lzc.thinkingInJava.util.Enums;

public enum MEAL2 {
    APPETIZER(Food.Appetizer.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    MAINCOURSE(Food.MainCourse.class);
    private Food[] values;
    private MEAL2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
    public interface Food {
        enum Appetizer implements Food {
            SALAD,SOUP,SPRING_ROLLS;
        }
        enum MainCourse implements Food {
            LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
        }
        enum Dessert implements Food {
            TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
        }
        enum Coffee implements Food {
            BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,LATTE,CAPPUCCINO,TEA,HERB_TEA;
        }
    };

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            for(MEAL2 meal2 : MEAL2.values()){
                Food food = meal2.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
