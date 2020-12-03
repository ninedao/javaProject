package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    protected final int size = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[size];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % size;
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> listIterator = buckets[index].listIterator();
        while(listIterator.hasNext()){
            MapEntry<K, V> ipair = listIterator.next();
            if(ipair.getKey().equals(key)){
                oldValue = ipair.getValue();
                listIterator.set(pair);
                found = true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % size;
        if(buckets[index] == null){
            return null;
        }
        for(MapEntry<K, V> pair : buckets[index]){
            if(pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for(LinkedList<MapEntry<K, V>> bucket : buckets){
            if(bucket == null){
                continue;
            }
            for(MapEntry<K, V> pair : bucket){
                set.add(pair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
