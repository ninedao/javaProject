package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

class SimpleHashMap7<K, V> extends SimpleHashMap<K, V>{
    private int count;
    private static final double loadfactor = 0.75;
    private final static int initialCapacity = 11;
    private int capacity = initialCapacity;
    private int threshold = (int)(capacity * loadfactor);
    {
        buckets = new LinkedList[capacity];
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode() % capacity);
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found  = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found){
            if(count >= threshold){
                reHash();
            }
            if(buckets[index] == null){
                buckets[index] = new LinkedList<MapEntry<K, V>>();
            }
            buckets[index].add(pair);
            ++count;
        }
        return oldValue;
    }
    private boolean isPrime(int candidate) {
        for(int j = 2; j < candidate; j++){
            if(candidate % j == 0){
                return false;
            }
        }
        return true;
    }
    private int nextPrime(int candidate) {
        while(!isPrime(candidate)){
            candidate++;
        }
        return candidate;
    }
    private void reHash(){
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        capacity = nextPrime(capacity * 2);
        System.out.println("Rehashing, new Capacity = " + capacity);
        buckets = new LinkedList[capacity];
        threshold = (int) (capacity * loadfactor);
        count = 0;
        while(it.hasNext()){
            Map.Entry<K, V> me = it.next();
            put(me.getKey(), me.getValue());
        }
    }
}

public class E39_SimpleHashMap7 {
    public static void main(String[] args) {
        SimpleHashMap7<String, String> m = new SimpleHashMap7<String, String>();
        m.putAll(Countries.capitals(50));
        System.out.println(m);
    }
}
