package com.lzc.thinkingInJava.generics;

import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get(){
        return element;
    }
}
class A2 extends NotSelfBounded<A2>{}
class B2 extends NotSelfBounded<A2>{}
class C2 extends NotSelfBounded<C2>{
    C2 setAndGet(C2 arg){
        set(arg);
        return get();
    }
}
class D2{}
class E2 extends NotSelfBounded<D2>{}

