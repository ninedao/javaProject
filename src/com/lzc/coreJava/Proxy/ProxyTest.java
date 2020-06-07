package com.lzc.coreJava.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

import static com.lzc.coreJava.ReflectionTest.analyClass;

/**
 * Created by POPO LIU on 2020-06-07.
 */
public class ProxyTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(1);
        Object[] b = new Object[1000];
        for(int i = 0; i < 1000; i++){
            Integer value = i + 1;
            Tracehandler t = new Tracehandler(i);
            // 构建了实现指定接口的代理类的实例，
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, t);
            b[i] = proxy;
        }
        Integer key = new Random().nextInt(b.length) + 1;
        int result = Arrays.binarySearch(b, key);
        if(result > 0) {
            analyClass("com.sun.proxy.$Proxy0");
            System.out.println(b[result].getClass());
        }
    }
}
class Tracehandler implements InvocationHandler {
    private Object target;
    public Tracehandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(args != null){
            for(int i = 0; i < args.length; i++){
                System.out.print(args[i]);
                if(i < args.length - 1){
                    System.out.println(".");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
