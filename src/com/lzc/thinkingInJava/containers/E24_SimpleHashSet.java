package com.lzc.thinkingInJava.containers;

import com.lzc.thinkingInJava.util.Countries;

import java.util.*;
 class SimpleHashSet<E> extends  AbstractSet<E>{
     protected final int size = 997;
     @SuppressWarnings("unchecked")
     LinkedList<E>[] buckets = new LinkedList[size];

     @Override
     public boolean isEmpty() {
         for(LinkedList<E> list : buckets){
             if(list != null){
                 return false;
             }
         }
         return true;
     }

     @Override
     public boolean contains(Object o) {
         int index = Math.abs(o.hashCode()) % size;
         if(buckets[index] == null){
             return false;
         }
         for(E e : buckets[index]){
             if(e.equals(o)){
                 return true;
             }
         }
         return false;
     }

     @Override
     public boolean add(E e) {
         int index = Math.abs(e.hashCode()) % size;

         if(buckets[index] == null){
             buckets[index] = new LinkedList<E>();
         }
         LinkedList<E> linkedList = buckets[index];
         Iterator it = linkedList.iterator();
         while(it.hasNext()){
             if(it.next().equals(e)){
                 return false;
             }
         }
         linkedList.add(e);
         return true;
     }

     @Override
     public Iterator<E> iterator() {
         return new Iterator<E>() {
             private  int count;
             private int index1, index2;
             private boolean canRemove;
             @Override
             public boolean hasNext() {
                 return count < size();
             }

             @Override
             public E next() {
                 if(hasNext()){
                     canRemove = true;
                     count++;
                     for(;;){
                         while(buckets[index1] == null){
                             ++index1;
                         }
                         try{
                             return buckets[index1].get(index2++);
                         } catch(IndexOutOfBoundsException e){
                             index1++;
                             index2 = 0;
                         }
                     }
                 }
                 throw new NoSuchElementException();
             }

             @Override
             public void remove() {
                 if(canRemove){
                     canRemove = false;
                     buckets[index1].remove(--index2);
                     if(buckets[index1].isEmpty()){
                         buckets[index1++] = null;
                     }
                     --count;
                 }else{
                     throw new IllegalArgumentException();
                 }
             }
         };
     }

     @Override
     public int size() {
         int i = 0;
         for(LinkedList<E> list : buckets){
             if(list != null){
                 i += list.size();
             }
         }
         return i;
     }
 }
public class E24_SimpleHashSet<E> {
    public static void main(String[] args) {
        SimpleHashSet<String>m= new SimpleHashSet<String>();
        m.addAll(Countries.names(10));
        m.addAll(Countries.names(10));
        System.out.println("m = "+ m);
        System.out.println("m.size()="+m.size());
        Iterator<String> it = m.iterator();
        System.out.println("it.next()= "+ it.next());
        it.remove();
        System.out.println("it.next()="+ it.next());
        System.out.println("m =" + m);
        m.remove("ALGERIA");
        System.out.println("m="+ m);


    }
}
