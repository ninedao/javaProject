package com.lzc.thinkingInJava.containers;

import java.util.*;

import static com.lzc.thinkingInJava.containers.Maps.test;

class SlowMap2<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        if(key == null){
            throw new NullPointerException();
        }
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
        if(key == null){
            throw new NullPointerException();
        }
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }
    private class EntrySet extends AbstractSet<Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;
                boolean canRemove;
                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public Entry<K, V> next() {
                    canRemove = true;
                    index++;
                    return new MapEntry<K, V>(keys.get(index), values.get(index));
                }
                public void remove(){
                    if(!canRemove){
                        throw new IllegalArgumentException();
                    }
                    canRemove = false;
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
        @Override
        public boolean contains(Object o) {
            if(o instanceof MapEntry){
                MapEntry<K, V> map = (MapEntry<K, V>)o;
                K key = map.getKey();
                if(keys.contains(key)){
                    return map.equals(new MapEntry<K, V>(key, get(key)));
                }
            }
            return false;
        }
        @Override
        public boolean remove (Object o){
            if(contains(o)){
                MapEntry<K, V> map = (MapEntry<K, V>)o;
                K k = map.getKey();
                V v = map.getValue();
                keys.remove(k);
                values.remove(v);
                return true;
            }
            return false;
        }
        @Override
        public int size() {
            return keys.size();
        }
        @Override
        public void clear(){
            keys.clear();
            values.clear();
        }
    }
    private EntrySet entrySet = new EntrySet();
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }
}
public class E16_SlowMapTest {
    public static void main(String[] args) {
        test(new SlowMap<Integer, String>());
        test(new SlowMap2<Integer, String>());
    }

}
