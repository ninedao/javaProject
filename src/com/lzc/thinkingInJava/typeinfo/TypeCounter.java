package com.lzc.thinkingInJava.typeinfo;

import java.util.HashMap;
import java.util.Map;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class baseType;
    public TypeCounter(Class baseType) {
        this.baseType = baseType;
    }
    public void count(Object obj) {
        Class type = obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + "incorrect type: " + type + ", should be type or subtype of " +baseType);
        }
        countCLass(type);
    }
    public void countCLass(Class<?> type){
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countCLass(superClass);
        }

    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("{");
        for(Map.Entry<Class<?>, Integer> pair : entrySet()) {
            b.append(pair.getKey().getSimpleName());
            b.append("=");
            b.append(pair.getValue());
            b.append(", ");
        }
        b.delete(b.length() - 2, b.length());
        b.append("}");
        return b.toString();
    }
}
