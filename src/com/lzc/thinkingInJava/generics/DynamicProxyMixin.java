package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.TwoTuple;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static com.lzc.thinkingInJava.util.Tuple.tuple;

class MixinProxy implements InvocationHandler{
    Map<String, Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object, Class<?>> ... pairs) {
        delegatesByMethod = new HashMap<String, Object>();
        for(TwoTuple<Object, Class<?>> pair : pairs) {
            for(Method method : pair.b.getMethods()) {
                String methodName = method.getName();
                if(!delegatesByMethod.containsKey(methodName)){
                    delegatesByMethod.put(methodName, pair.a);
                }
            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据方法名字调用不同object的方法
        Object obj = delegatesByMethod.get(method.getName());
        return method.invoke(obj, args);
    }
    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple ... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for(int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].b;
        }
        ClassLoader loader = pairs[0].a.getClass().getClassLoader();
        return Proxy.newProxyInstance(loader, interfaces, new MixinProxy(pairs));
    }
}
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
