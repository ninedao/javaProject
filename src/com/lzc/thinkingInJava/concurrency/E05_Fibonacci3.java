package com.lzc.thinkingInJava.concurrency;

import com.lzc.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

class Fibonacci3 implements Generator<Integer>, Callable {
    private final int n;
    private int count = 1;
    private int[] flag;
    public Fibonacci3(int n) {
        this.n = n;
        flag = new int[n + 1];
    }
    public int fib(int n) {
        if(n == 1 || n == 2){
        return 1;
        }else{
        if(flag[n-1] == 0){
        flag[n-1] = fib(n-1);
        }
        if(flag[n-2] == 0){
        flag[n-2] =  fib(n - 2);
        }
        return flag[n-1] + flag[n-2];
        }
    }
    @Override
    public Integer next() {
        return fib(count++);
    }

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += next();
        }
        return sum;
    }
}
public class E05_Fibonacci3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> arrayList = new ArrayList<Future<Integer>>();
        for(int i = 1; i <= 5; i++) {
            arrayList.add(executorService.submit(new Fibonacci3(i)));
        }
        for(Future<Integer> fs : arrayList){
            try{
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return ;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}
