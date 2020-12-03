package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;

class SimpleHashMap3<K, V> extends SimpleHashMap<K, V> {


    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new LinkedList[size];
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % size;
        if(buckets[index] == null){
            return null;
        }
        Iterator<MapEntry<K, V>> it = buckets[index].iterator();
        while(it.hasNext()){
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                V oldValue = iPair.getValue();
                it.remove();
                return oldValue;
            }
        }
        return null;
    }
}
public class E22_SimpleHashMapClearRemove {
    public static void main(String[] args) {
        SimpleHashMap3<String, String> map = new SimpleHashMap3<String,String>();
        map.putAll(Countries.capitals(25));
        System.out.println(map.get("CONGO"));
        map.remove("CONGO");
        System.out.println(map.get("CONGO"));
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }
}
