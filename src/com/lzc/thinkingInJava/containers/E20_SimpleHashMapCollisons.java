package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.*;

class SimpleHashMap2<K, V> extends SimpleHashMap<K, V> {
    @Override

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % size;
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }else{
            System.out.println("Collision while adding\n" + pair +"" +
                    "\nBucket alreasy contains:");
            Iterator<MapEntry<K, V>> it = buckets[index].iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }

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
        int i = 0;
        for(MapEntry<K, V> pair : buckets[index]){
            i++;
            if(pair.getKey().equals(key)){
                System.out.println("找了" + i + "次找到"+key);
                return pair.getValue();
            }
        }
        return null;
    }
}
public class E20_SimpleHashMapCollisons{

    public static void main(String[] args) {
        SimpleHashMap2<String, String> m = new SimpleHashMap2<String, String>();
        m.putAll(Countries.capitals(25));

        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("LESOTHO"));
    }
}
