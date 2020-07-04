package com.lzc.thinkingInJava.holding;

import com.lzc.thinkingInJava.typeinfo.pets.Pet;
import com.lzc.thinkingInJava.typeinfo.pets.Pets;
import com.lzc.thinkingInJava.typeinfo.pets.Rat;

import java.util.LinkedList;
import static  com.lzc.thinkingInJava.util.Print.*;
public class LinkedListFeatures {
    public static void main(String[] args){
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        print(pets);
        // getFirst()和element()一样，都是检索第一个但是不删除,但是为空会抛异常，peek()是检索头但不删除，为空会返回null
        print("pets.getFirst(): " + pets.getFirst());
        print("pets.element(): " + pets.element());
        print("pets.peek(): " + pets.peek());

        print("pets.remove(): " + pets.remove());
        print("pets.removeFirst(): " + pets.removeFirst());
        print("pets.poll(): " + pets.poll());//检索并删除此列表的头（第一个元素）
        print(pets);
        pets.addFirst(new Rat());
        print("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());//将指定的元素添加为此列表的尾部（最后一个元素）
        print("After offer(): " + pets);
        pets.add(Pets.randomPet());
        print("After add(): " + pets);
        pets.addLast(Pets.randomPet());
        print("After addLast(): " + pets);
        print("pets.removeLast(): " + pets.removeLast());
    }
}
