package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.TextFile;

import java.util.LinkedHashMap;
import java.util.List;
class AssociativeArray1<K, V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray1(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
        for(int i = 0; i < index; i++){
            if(key.equals(pairs[i][0])){
                pairs[i][1]=value;
                return;
            }
        }
        if(index >= pairs.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }
    @SuppressWarnings("uncheaked")
    public V get(K key) {
        for(int i = 0; i < index; i++){
            if(key.equals(pairs[i][0])){
                return (V) pairs[i][1];
            }
        }
        return null;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i < index - 1){
                result.append("\n");
            }
        }
        return result.toString();
    }
}
public class E13_WordCounter {
    public static void main(String[] args) {
        List<String> list = new TextFile("C:\\LocalFiles\\project\\IdeaProjects\\javaProject\\src\\com\\lzc\\thinkingInJava\\containers\\E13_WordCounter.java","\\W+");
        AssociativeArray1<String, Integer> associativeArray = new AssociativeArray1<String, Integer>(list.size());
        for(String s : list){
            Integer count = associativeArray.get(s);
            associativeArray.put(s, count == null ? 1 : count + 1);
        }
        System.out.println(associativeArray.toString());
    }
}
