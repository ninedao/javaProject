package com.lzc.thinkingInJava.containers;

import java.util.Map;
import java.util.Objects;

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K k;
    private V v;
    public MapEntry(K k, V v) {
        this.k = k;
        this.v = v;
    }
    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public V setValue(V value) {
        V result = v;
        this.v = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)){
            return false;
        }
        MapEntry me = (MapEntry)o;
        return (k == null ? me.getKey() == null : k.equals(me.getKey())) &&
                (v == null ? me.getValue() == null : v.equals(me.getValue()));
    }

    @Override
    public int hashCode() {
        return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
    }

    @Override
    public String toString() {
        return k + "=" + v;
    }
}
