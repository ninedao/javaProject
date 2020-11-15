package com.lzc.thinkingInJava.containers;

import java.util.NoSuchElementException;

interface SListIterator<T> {
    boolean hasNext();
    T next();
    void remove();
    void add(T element);
}
class SList<T>{
    private final Link<T> header = new Link<T>(null, null);
    SList(){
        header.next = header;
    }
    private class Link<T> {
        T elemnt;
        Link<T> next;
        Link(T element, Link<T> next) {
            this.elemnt = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append("[");
        for(SListIterator<T> it = iterator(); it.hasNext();){
            T element = it.next();
            sb.append(element == this ? "this element" : String.valueOf(element));
            if(it.hasNext()){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public SListIterator<T> iterator(){
        return new SListIteratorImpl();
    }
    private class SListIteratorImpl implements SListIterator<T>{
        private Link<T> lastReturned = header;
        private Link<T> next;
        SListIteratorImpl(){
            next = header.next;
        }
        @Override
        public boolean hasNext() {
            return next != header;
        }

        @Override
        public T next() {
            if(next == header) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            return lastReturned.elemnt;
        }

        @Override
        public void remove() {
            if(next == lastReturned){
                throw new IllegalStateException();
            }
            for(Link<T> curr = header; ;curr = curr.next){
                if(curr.next == lastReturned){
                    curr.next = lastReturned.next;
                    break;
                }
            }
            lastReturned = header;
        }

        @Override
        public void add(T element) {
            lastReturned = header;
            Link<T> link = new Link<T>(element, next);
            if(header.next == header) {
                header.next = link;
            }else{
                for(Link<T> curr = header; ;curr = curr.next){
                    if(curr.next == header){
                        curr.next = link;
                        break;
                    }
                }
            }
        }
    }
}
public class E08_SList {
    public static void main(String[] args) {
        System.out.println("DemonStrating SListIterator...");
        SList<String> sl = new SList<String>();
        System.out.println(sl);
        SListIterator<String> slist = sl.iterator();
        slist.add("One");
        slist.add("Two");
        slist.add("Three");
        System.out.println(slist.hasNext());
        System.out.println(sl);
    }
}
