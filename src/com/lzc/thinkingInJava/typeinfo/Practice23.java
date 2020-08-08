package com.lzc.thinkingInJava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Practice23_DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    private static long count;
    public Practice23_DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.toString());
        return method.invoke(proxied, args);
    }
}

public class Practice23 {
    public static void consumer(Interface1 iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject1 r = new RealObject1();
        consumer(r);
        Interface1 f = (Interface1) Proxy.newProxyInstance(Interface1.class.getClassLoader(), new Class[]{Interface1.class}, new Practice23_DynamicProxyHandler(r));
        consumer(f);
        System.out.println();
        consumer(f);
        System.out.println();
        consumer(f);
    }
}
