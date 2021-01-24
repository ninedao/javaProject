package com.lzc.thinkingInJava.concurrency;

import com.lzc.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FibonacciSum2 {
    static ExecutorService executorService;

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    public static  void init() {
        executorService = Executors.newCachedThreadPool();
    }
    public  static synchronized Future<Integer> runTask( int n) {
        Future<Integer> result = (Future<Integer>) executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += fib(i);
                }
                return sum;
            }
        });
        return result;
    }

    public static synchronized void shutdown() {
        if (executorService != null)
            executorService.shutdown();
        executorService = null;
    }
}
public class E10_FibonacciSum2 {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        FibonacciSum2.init();
        for (int i = 1; i <= 5; i++) {
            results.add(FibonacciSum2.runTask(i));
        }
        Thread.yield();
        FibonacciSum2.shutdown();
        for (Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
