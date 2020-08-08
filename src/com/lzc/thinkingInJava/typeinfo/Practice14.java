package com.lzc.thinkingInJava.typeinfo;

import com.lzc.thinkingInJava.typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part2 {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part2>> partFactories = new ArrayList<Class<? extends Part2>>();
    static {
        partFactories.add(FuelFilter2.class);
        partFactories.add(AirFilter2.class);
        partFactories.add(CabinFilter2.class);
        partFactories.add(OilFilter2.class);
        partFactories.add(FanBelt2.class);
        partFactories.add(GeneratorBelt2.class);
        partFactories.add(PowerSteeringBelt2.class);
    }
    private static Random rand = new Random(47);
    public static Part2 createRandom() throws IllegalAccessException, InstantiationException {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).newInstance();
    }
}

class Filter2 extends Part2 {}

class FuelFilter2 extends Filter2{}

class AirFilter2 extends Filter2{}

class CabinFilter2 extends Filter2{}

class OilFilter2 extends Filter2{}

class Belt2 extends Part2 {}

class FanBelt2 extends Belt2 {}

class GeneratorBelt2 extends Belt2 {}

class PowerSteeringBelt2 extends Belt2 {}

public class Practice14 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        for(int i = 0; i < 10; i++) {
            System.out.println(Part2.createRandom());
        }
    }
}
