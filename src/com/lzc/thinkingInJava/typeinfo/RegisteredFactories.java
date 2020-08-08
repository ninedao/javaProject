package com.lzc.thinkingInJava.typeinfo;

import com.lzc.thinkingInJava.typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
class Filter extends Part {}
class FuelFilter extends Filter{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class CabinFilter extends Filter{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<CabinFilter>{
        @Override
        public CabinFilter create() {
            return new CabinFilter();
        }
    }
}
class OilFilter extends Filter{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}
class Belt extends Part {}
class FanBelt extends Belt{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<FanBelt>{
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
class GeneratorBelt extends Belt{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<GeneratorBelt>{
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
class PowerSteeringBelt extends Belt{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<PowerSteeringBelt>{
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
