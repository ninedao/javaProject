package com.lzc.thinkingInJava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try{
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return ;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
