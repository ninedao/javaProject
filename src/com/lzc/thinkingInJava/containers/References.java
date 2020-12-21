package com.lzc.thinkingInJava.containers;

import java.io.File;
import java.io.FileFilter;
import java.lang.ref.*;
import java.util.LinkedList;

class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);;
    }
}
public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    public static void changeQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null){
            System.out.println("In queue: " + inq.isEnqueued());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        if(args.length > 0){
            size = Integer.valueOf(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for(int i = 0; i < size; i++){
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created: " + sa.getLast());
            changeQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for(int i = 0; i < size; i++){
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
            System.out.println("Just created: " + wa.getLast());
            changeQueue();
        }
        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("weak"));
        System.gc();
        System.out.println(1);

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for(int i = 0; i < size; i++){
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created: " + pa.getLast());
            changeQueue();
        }
        File f = new File("");
        f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });
    }
}
