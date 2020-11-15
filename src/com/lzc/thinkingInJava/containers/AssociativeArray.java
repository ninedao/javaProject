package com.lzc.thinkingInJava.containers;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
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

    public static void main(String[] args) {
        AssociativeArray<String,String> associativeArray = new AssociativeArray<String,String>(6);
        associativeArray.put("sky","blue");
        associativeArray.put("grass","green");
        associativeArray.put("ocean","dancing");
        associativeArray.put("tree","tall");
        associativeArray.put("earth","brown");
        associativeArray.put("sun","warm");
        try{
            associativeArray.put("extra", "object");
        }catch(Exception e) {
            System.out.println("Too many objects!");
        }
        System.out.println(associativeArray);
        System.out.println(associativeArray.get("ocean"));
    }
}
