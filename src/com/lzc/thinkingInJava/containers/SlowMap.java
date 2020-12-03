package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        V oldvalue = get(key);
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.add(keys.indexOf(key), value);
        }
        return oldvalue;
    }
    public V get(Object key) {
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext()){
            set.add(new MapEntry<K, V>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<String, String>();
        map.putAll(Countries.capitals(15));
        System.out.println(map);
        System.out.println(map.get("BENIN"));
        System.out.println(map.entrySet());
    }
}
