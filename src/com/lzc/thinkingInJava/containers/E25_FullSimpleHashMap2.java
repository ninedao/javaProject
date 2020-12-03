package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.*;

import static com.lzc.thinkingInJava.util.Print.print;

class SimpleHashMap5<K, V> extends AbstractMap<K, V> {
    static class Entry<K, V> implements Map.Entry<K, V>{
        private K key;
        private V value;
        Entry<K, V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Entry){
                Entry<K, V> O = (Entry<K, V>)o;
                Object o1 = this.getKey();
                Object o2 = O.getKey();
                if(o1.equals(o2)){
                    Object v1 = getValue();
                    Object v2 = O.getValue();
                    return v1 == null ? v2 == null : v1.equals(v2);
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
    static final int SIZE = 997;
    Entry<K, V>[] buckets = new Entry[SIZE];
    @Override
    public int size() {
        int sz = 0;
        for(int i = 0; i < SIZE; i++){
            for(Entry<K, V> pair = buckets[i]; pair != null ; pair = pair.next){
                sz++;
            }
        }
        return sz;
    }

    @Override
    public boolean isEmpty() {
        for(Entry<K, V>  bucket : buckets){
            if(bucket != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null){
            return null;
        }
        for(Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next){
            if(pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V oldValue = null;
        Entry<K, V> newPair = new Entry<K, V>(key, value);
        if(buckets[index] == null){
            buckets[index] = newPair;
        }
        Entry<K, V> prevPair = null;
        boolean found = false;
        for(Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next){
            if(pair.getKey().equals(key)){
                oldValue = pair.value;
                if(prevPair != null){
                    prevPair.next = pair;
                }else{
                    buckets[index] = newPair;
                }
                newPair.next = pair.next;
                found = true;
                break;
            }
            prevPair = pair;
        }
        if(!found){
            prevPair.next = newPair;
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        Entry<K, V> prevPair = null;
        for(Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next){
            if(pair.getKey().equals(key)){
                V value = pair.getValue();
                if(prevPair != null){
                    prevPair.next = pair.next;
                }else{
                    buckets[index] = null;
                }
                return value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        buckets = new Entry[SIZE];
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        for(Entry<K, V> bucket : buckets){
            for(Entry<K, V> pair = bucket; pair != null; pair = pair.next){
                set.add(pair);
            }
        }
        return set;
    }
}

public class E25_FullSimpleHashMap2 {
    public static void main(String[] args) {
        SimpleHashMap5<String,String> m = new SimpleHashMap5<String,String>(),
                m2 = new SimpleHashMap5<String,String>();
        m.putAll(Countries.capitals(10));
        m2.putAll(Countries.capitals(10));
        print("m.size()=" + m.size());
        print("m.isEmpty()="+m.isEmpty());
        print("m.equals(m2)="+m.equals(m2));
        print("m.containsKey(\"BENIN\")="+
                m.containsKey("BENIN"));
        print("m.containsKey(\"MARS\")=" + m.containsKey("HMARS"));
        print("m.keySet()="+m.keySet());
        print("m.values()="+m.values());
        m.remove("ALGERIA");
        print("m = "+ m);




    }
}
