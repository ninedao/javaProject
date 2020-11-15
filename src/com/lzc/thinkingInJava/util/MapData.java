package com.lzc.thinkingInJava.util;

import java.util.LinkedHashMap;

public class MapData<K, V> extends LinkedHashMap<K,V> {
    public MapData(Generator<Pair<K,V>> generator, int quality){
        for(int i = 0; i < quality; i++) {
            Pair<K,V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }
    public MapData(Generator<K> kGenerator, Generator<V> vGenerator, int quality) {
        for(int i = 0; i < quality; i++) {
            put(kGenerator.next(), vGenerator.next());
        }
    }
    public MapData(Generator<K> kGenerator, V value, int quality) {
        for(int i = 0; i < quality; i++) {
            put(kGenerator.next(), value);
        }
    }
    public MapData(Iterable<K> kGen, Generator<V> vGen) {
        for(K key : kGen) {
            put(key, vGen.next());
        }
    }
    public MapData(Iterable<K> kGen, V vGen) {
        for(K key : kGen) {
            put(key, vGen);
        }
    }
    public static <K, V> MapData<K,V> map(Generator<Pair<K,V>> generator, int quality){
        return new MapData<K,V>(generator, quality);
    }
    public static <K, V> MapData<K,V> map(Generator<K> kGenerator, Generator<V> vGenerator, int quality){
        return new MapData<K,V>(kGenerator, vGenerator, quality);
    }
    public static <K, V> MapData<K,V> map(Generator<K> kGenerator, V value, int quality){
        return new MapData<K,V>(kGenerator, value, quality);
    }
    public static <K, V> MapData<K,V> map(Iterable<K> kGen, Generator<V> vGen){
        return new MapData<K,V>(kGen, vGen);
    }
    public static <K, V> MapData<K,V> map(Iterable<K> kGen, V vGen){
        return new MapData<K,V>(kGen, vGen);
    }
}
