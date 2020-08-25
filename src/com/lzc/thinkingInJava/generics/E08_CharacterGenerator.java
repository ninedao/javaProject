package com.lzc.thinkingInJava.generics;

import com.lzc.thinkingInJava.util.Generator;

import java.util.Iterator;
import java.util.Random;

class StoryCharacters {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
class GoodGuy extends  StoryCharacters {
    @Override
    public String toString() {
        return super.toString() + " is a good guy";
    }
}
class BadGuy extends  StoryCharacters {
    @Override
    public String toString() {
        return super.toString() + " is a bad guy";
    }
}
class Morton extends BadGuy{}
class Frank extends BadGuy{}
class Harmonica extends GoodGuy{}
class Cheyenne extends GoodGuy{}
class CharacterGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class[] types = {Morton.class, Frank.class, Harmonica.class, Cheyenne.class};
    private static Random rand = new Random(47);
    public CharacterGenerator(){}
    private int size = 0;
    public CharacterGenerator(int count){
        size = count;
    }
    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new Iterator<StoryCharacters>() {
            private int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public StoryCharacters next() {
                count--;
                return CharacterGenerator.this.next();
            }
        };
    }
}
public class E08_CharacterGenerator {
    public static void main(String[] args) {
        CharacterGenerator gen = new CharacterGenerator();
        for(int i = 0; i < 7; i++){
            System.out.println(gen.next());
        }
        for(StoryCharacters p : new CharacterGenerator(7)){
            System.out.println(p);
        }
    }
}
