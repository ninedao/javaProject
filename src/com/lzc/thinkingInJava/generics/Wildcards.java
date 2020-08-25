package com.lzc.thinkingInJava.generics;

public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        //Warning:对作为原始类型com.lzc.thinkingInJava.generics.Holder的成员的set(T)的调用未经过检查
        //holder.set(arg);
        //holder.set(new Wildcards());

        //T t = holder.get();
        Object obj = holder.get();
    }
    static void unboundedArg(Holder<?> holder, Object arg) {
        //Error
        //holder.set(arg);
        //holder.set(new Wildcards());

        //T t = holder.get();
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //T t = (T) holder.get();
        Object obj = holder.get();
        //System.out.println(t);
        //System.out.println(obj);
    }
    public static void main(String[] args) {

        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        //warnings
        //Object r1 = exact1(raw);
        Long r2 = exact1(qualified) ;
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        //warnings
        //Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        //Error
        //Long r7 = exact2(unbounded, lng);
        //Long r8 = exact2(bounded, lng);
        // warning
        //Long r9 = wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        //Warning:未经检查的转换
        //wildSuperType(raw, lng);
        wildSuperType(qualified, lng);
        //无法将类 com.lzc.thinkingInJava.generics.Wildcards中的方法 wildSuperType应用到给定类型;
        //wildSuperType(unbounded, lng);
        //wildSuperType(bounded, lng);

    }
}
