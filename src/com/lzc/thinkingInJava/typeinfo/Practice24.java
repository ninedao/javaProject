package com.lzc.thinkingInJava.typeinfo;

import com.lzc.thinkingInJava.typeinfo.factory.Factory;
import com.lzc.thinkingInJava.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class NullPartProxyHandler implements InvocationHandler {
    private String nullName;
    private IPart p = new NullPart();
    public NullPartProxyHandler(Class<? extends IPart> type) {
        this.nullName = type.getSimpleName() + " NullPart";
    }
    class NullPart implements Null, IPart {
        @Override
        public String toString() {
            return nullName;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(p, args);
    }
}
interface IPart {}
class Part3 implements IPart {
    public static IPart newNull(Class<? extends IPart> type) {
        return (IPart) Proxy.newProxyInstance(IPart.class.getClassLoader(), new Class[]{Null.class, IPart.class}, new NullPartProxyHandler(type));
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part3>> partFactories = new ArrayList<Factory<? extends Part3>>();
    static {
        partFactories.add(new FuelFilter3.Factory());
        partFactories.add(new AirFilter3.Factory());
        partFactories.add(new CabinFilter3.Factory());
        partFactories.add(new OilFilter3.Factory());
        partFactories.add(new FanBelt3.Factory());
        partFactories.add(new GeneratorBelt3.Factory());
        partFactories.add(new PowerSteeringBelt3.Factory());
    }
    private static Random rand = new Random(47);
    public static Part3 createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter3 extends Part3 {}

class FuelFilter3 extends Filter3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<FuelFilter3>{
        @Override
        public FuelFilter3 create() {
            return new FuelFilter3();
        }
    }
}

class AirFilter3 extends Filter3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<AirFilter3>{
        @Override
        public AirFilter3 create() {
            return new AirFilter3();
        }
    }
}

class CabinFilter3 extends Filter3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<CabinFilter3>{
        @Override
        public CabinFilter3 create() {
            return new CabinFilter3();
        }
    }
}

class OilFilter3 extends Filter3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<OilFilter3>{
        @Override
        public OilFilter3 create() {
            return new OilFilter3();
        }
    }
}

class Belt3 extends Part3 {}

class FanBelt3 extends Belt3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<FanBelt3>{
        @Override
        public FanBelt3 create() {
            return new FanBelt3();
        }
    }
}

class GeneratorBelt3 extends Belt3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<GeneratorBelt3>{
        @Override
        public GeneratorBelt3 create() {
            return new GeneratorBelt3();
        }
    }
}

class PowerSteeringBelt3 extends Belt3{
    public static class Factory implements com.lzc.thinkingInJava.typeinfo.factory.Factory<PowerSteeringBelt3>{
        @Override
        public PowerSteeringBelt3 create() {
            return new PowerSteeringBelt3();
        }
    }
}

public class Practice24 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            IPart p = Part3.createRandom();
            System.out.println(p);
            System.out.println(Part3.newNull(p.getClass()));
        }
    }
}
