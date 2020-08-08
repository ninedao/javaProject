package com.lzc.thinkingInJava.typeinfo.pets;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer>{
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }
    public static void countPets(PetCreator petCreator) {
        PetCounter p = new PetCounter();
        for(Pet pet : petCreator.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if(pet instanceof Pet) {
                p.count("Pet");
            }
            if(pet instanceof Dog) {
                p.count("Dog");
            }
            if(pet instanceof Mutt) {
                p.count("Mutt");
            }
            if(pet instanceof Pug) {
                p.count("Pug");
            }
            if(pet instanceof Cat) {
                p.count("Cat");
            }
            if(pet instanceof EgyptianMau) {
                p.count("EgyptianMau");
            }
            if(pet instanceof Manx) {
                p.count("Manx");
            }
            if(pet instanceof Cymric) {
                p.count("Cymric");
            }
            if(pet instanceof Rodent) {
                p.count("Rodent");
            }
            if(pet instanceof Rat) {
                p.count("Rat");
            }
            if(pet instanceof Mouse) {
                p.count("Mouse");
            }
            if(pet instanceof Hamster) {
                p.count("Hamster");
            }
            if(pet instanceof Gerbil) {
                p.count("Gerbil");
            }
        }
        System.out.println();
        System.out.println(p);
    }
    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
