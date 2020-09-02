package com.lzc.thinkingInJava.generics;

import static com.lzc.thinkingInJava.util.Tuple.tuple;

public class E39_DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class),
                tuple(new E37_ColoredImp(), E37_Colored.class ));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        E37_Colored c = (E37_Colored) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());;
        System.out.println(c.getColored());
    }
}
