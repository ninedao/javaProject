package com.lzc.thinkingInJava.generics;

import java.awt.*;

class Coffee{
    private String type;
    public Coffee(){}
    public Coffee(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}

class Decorator_Coffee extends Coffee {
    private Coffee coffee;
    public Decorator_Coffee(Coffee coffee){
        this.coffee =coffee;
    }
    @Override
    public String getType() {
        return coffee.getType();
    }

    @Override
    public void setType(String type) {
        coffee.setType(type);
    }
}
class SteamedMilk extends Decorator_Coffee {
    public SteamedMilk(Coffee coffee) {
        super(coffee);
        setType(getType() + " & Steamed Milk");
    }
}
class Foam extends Decorator_Coffee {
    public Foam(Coffee coffee) {
        super(coffee);
        setType(getType() + " & Foam");
    }
}
class Chocolate extends Decorator_Coffee {
    private final Color color;
    public Chocolate(Coffee coffee, Color color) {
        super(coffee);
        this.color = color;
        setType(getType() + " & Chocolate[" + getColor() + "]");
    }

    public Color getColor() {
        return color;
    }
}
class Caramel extends Decorator_Coffee {
    public Caramel(Coffee coffee) {
        super(coffee);
        setType(getType() + " & Caramel");
    }
}
class Whippedcream extends Decorator_Coffee {
    public Whippedcream(Coffee coffee) {
        super(coffee);
        setType(getType() + " & Whippedcream");
    }
}

public class E38_Coffee {
    public static void main(String[] args) {
        Decorator_Coffee Capuccino = new Foam(new SteamedMilk(new Coffee("espresso")));
        System.out.println("Capuccino is: " +Capuccino.getType());
        Decorator_Coffee whiteChocolateCooffee = new Whippedcream(new Chocolate(new Coffee("hot coffee"), Color.white));
        System.out.println("WhiteChocolateCooffee is: " + whiteChocolateCooffee.getType());
    }
}
