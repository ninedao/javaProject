package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;

import static com.lzc.thinkingInJava.util.Print.print;

class SimpleHashMap4<K, V> extends SimpleHashMap3<K, V> {

    @Override
    public int size() {
        int i = 0;
        for(LinkedList<MapEntry<K, V>> node : buckets){
            if(node != null){
                i += node.size();
            }
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        for(LinkedList<MapEntry<K, V>> node : buckets){
            if(node != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % size;
        LinkedList<MapEntry<K, V>> list = buckets[index];
        if(list == null){
            return false;
        }
        for(MapEntry<K, V> node : list){

            if(node.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }
}

public class E23_FullSimpleHashMap {
    public static void main(String[] args) {
        SimpleHashMap4<String,String>
                m = new SimpleHashMap4<String,String>(),
                m2= new SimpleHashMap4<String,String>();
        m.putAll(Countries.capitals(10));
        m2.putAll(Countries.capitals(10));
        print("m.size()=" + m.size());
        print("m.isEmpty()=" + m.isEmpty());
        print("m.equals(m2)=" + m.equals(m2));
        print("m.containsKey(\"BENIN\")= " +
                m.containsKey("BENIN"));
        print("m.containsKey(\"MARS\")=" + m.containsKey("MARS"));
        print("m.keySet()="+m.keySet());
    print("m.values()="+m.values());


    }
}
