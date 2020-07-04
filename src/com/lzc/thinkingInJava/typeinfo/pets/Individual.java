package com.lzc.thinkingInJava.typeinfo.pets;

public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual(String name){
        this.name = name;
    }
    public Individual(){}

    public long id(){
        return id;
    }
    @Override
    public boolean equals(Object o){
        return o instanceof Individual && id == ((Individual)o).id();
    }
    public int hashCode(){
        int result = 127;
        if(name != null){
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int)id;
        return result;
    }
    @Override
    public int compareTo(Individual arg) {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0){
            return firstCompare;
        }
        if(name != null && arg.name != null){
            int secondCompare = name.compareTo(arg.name);
            return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }
}
