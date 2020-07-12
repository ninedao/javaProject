package com.lzc.thinkingInJava.exceptions;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

class Disposable {
    private static long counter = 0;
    private long id = counter++;
    private boolean disposed;
    public Disposable() {
        disposed = false;
    }
    void dispose() {
        disposed = true;
    }
    public void checkStatus(){
        System.out.println(id + " " + (disposed ? "disposed" : "not disposed" ));
    }
}
public class Practice23 {
    private Integer[] ai = new Integer[2];
    private Disposable d0;
    private Disposable d1;
    public Practice23() throws Exception{
        try {
            d0 = new Disposable();
            try {
                ai[2] = 2; 	// causes exception thrown and
                // caught in middle try loop
                try {
                    d1 = new Disposable();
                } catch(Exception e) {
                    println("Caught e in inner try loop");
                    e.printStackTrace(System.err);
                    println("Failed to create d1");
                }
            } catch(Exception e) {
                println("Caught e in middle try loop");
                e.printStackTrace(System.err);
                println("Disposing d0");
                d0.dispose(); // d0 would have been created
            }
        } catch(Exception e) {
            println("Caught e in outer try loop");
            e.printStackTrace(System.err);
            println("Failed to create d0");
        }
    }
    public static void main(String[] args){
        try {
            Practice23 p = new Practice23();
        } catch (Exception e) {
            System.err.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        }
    }
}
