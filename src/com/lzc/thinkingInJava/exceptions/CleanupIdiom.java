package com.lzc.thinkingInJava.exceptions;

class NeedsCleanup{
    private static long counter = 1;
    private final long id = counter ++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}
class ConstructionException extends Exception{}
class NeedsCleanuo2 extends NeedsCleanup {
    public NeedsCleanuo2() throws ConstructionException{};
}
public class CleanupIdiom {
    public static void main(String[] args){
        NeedsCleanup nc1 = new NeedsCleanup();
        try {

        } finally {
            nc1.dispose();
        }

        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {

        } finally {
            nc3.dispose();
            nc2.dispose();
        }

        try {
            NeedsCleanuo2 nc4 = new NeedsCleanuo2();
            try {
                NeedsCleanuo2 nc5 = new NeedsCleanuo2();
                try {

                } finally {
                    nc5.dispose();
                }
            } catch(ConstructionException e) {
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}
