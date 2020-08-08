package com.lzc.thinkingInJava.typeinfo.pets;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            //super(MapData);
            for(Class<? extends Pet> e : LiteralPetCreator.allTypes) {
                put(e, 0);
            }
        }
        public void count(Pet pet) {
            for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if(pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }
    public static void main(String[] args) {
        PetCounter p = new PetCounter();
        for(Pet pp : Pets.createArray(20)) {
            System.out.print(pp.getClass().getSimpleName() + " ");
            p.count(pp);
        }
        System.out.println();
        System.out.println(p);
    }
}
