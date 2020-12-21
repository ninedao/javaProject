package com.lzc.thinkingInJava.enumerated;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

enum CharacterCategory{
    VOWEL('a','e','i','o','u'){
        @Override
        public String toString() {
            return "vowel";
        }
    },
    SOMETIMES_A_VOWEL('w','y'){
        @Override
        public String toString() {
            return "sometimes_a_vowel";
        }
    },
    CONSONANT{
        @Override
        public String toString() {
            return "consonant";
        }
    };
    private HashSet<Character> set = new HashSet<Character>();
    CharacterCategory(Character... characters) {
        if(characters != null) {
            set.addAll(Arrays.asList(characters));
        }
    }
    public static CharacterCategory getCategory(Character c){
        if(VOWEL.set.contains(c)){
            return VOWEL;
        }
        if(SOMETIMES_A_VOWEL.set.contains(c)){
            return SOMETIMES_A_VOWEL;
        }
        return CONSONANT;
    }
}
public class E05_VowelsAndConsonants2 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        for(int i = 0; i < 100; i++) {
            int j = rand.nextInt(26) + 'a';
            System.out.print((char)j + "," + j + ": ");
            System.out.println(CharacterCategory.getCategory(((char)j)));
        }
    }
}
