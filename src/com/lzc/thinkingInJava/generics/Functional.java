package com.lzc.thinkingInJava.generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

interface Combiner<T> {
    T combine(T x, T y);
}
interface UnaryFunction<R, T> {
    R function(T x);
}
interface Collertor<T> extends UnaryFunction<T, T> {
    T result();
}
interface UnaryPredicate<T> {
    boolean test(T x);
}
public class Functional {
    public static <T> T reduce(Iterable<T> iterable, Combiner<T> combine) {
        Iterator<T> iterator = iterable.iterator();
        if(iterator.hasNext()) {
            T result = iterator.next();
            while(iterator.hasNext()) {
                result = combine.combine(result, iterator.next());
            }
            return result;
        }
        return null;
    }
    public static <T> Collertor<T> forEach(Iterable<T> seq, Collertor<T> collertor) {
        for(T t : seq) {
            collertor.function(t);
        }
        return collertor;
    }
    public static <R, T> List<R> transForm(Iterable<T> seq, UnaryFunction<R, T> unaryFunction) {
        List<R> result = new ArrayList<R>();
        for(T t : seq) {
            result.add(unaryFunction.function(t));
        }
        return result;
    }
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> unaryPredicate) {
        List<T> result = new ArrayList<T>();
        for(T t : seq) {
            if(unaryPredicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }
    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }
    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }
    static class BigIntegerAdder implements Combiner<BigInteger> {
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }
    static class AtomicLongAdder implements Combiner<AtomicLong> {
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }
    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;
        public GreaterThan(T bound) {
            this.bound = bound;
        }
        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }
    static class MultiplyingIntegerCollertor implements Collertor<Integer> {
        private Integer val = 1;
        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }
        @Override
        public Integer result() {
            return val;
        }
    }
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);
        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(filter(li, new GreaterThan<Integer>(4)));
        System.out.println(forEach(li, new MultiplyingIntegerCollertor()).result());
        System.out.println(forEach(filter(li, new GreaterThan<Integer>(4)), new MultiplyingIntegerCollertor()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(new BigDecimal(1.1, mc),
                new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc),
                new BigDecimal(4.4, mc));
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        System.out.println(rbd);

        System.out.println(filter(lbd, new GreaterThan<BigDecimal>(new BigDecimal(3))));

        List<BigInteger> lbi = new ArrayList<BigInteger>();
        BigInteger bi = BigInteger.valueOf(7);
        for(int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi);

        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11),
                new AtomicLong(47),
                new AtomicLong(74),
                new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral);

        System.out.println(transForm(lbd, new BigDecimalUlp()));
    }
}
