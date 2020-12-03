package com.lzc.thinkingInJava.containers;

import java.util.*;

class CustomSortedSet<T> implements SortedSet<T> {
    private final List<T> list;

    public CustomSortedSet(List<T> list) {
        this.list = list;
    }

    private CustomSortedSet() {
        this.list = new LinkedList<T>();
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public T first() {
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T last() {
        try {
            return list.get(list.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        checkForNull(o);

        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkForNullElements(c);
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
    private void checkForNullElements(Collection<?> c) {
        for(Iterator<?> it = c.iterator(); it.hasNext();){
            if(it.next() == null){
                throw new NullPointerException();
            }
        }
    }
    public void checkForNull(Object o) {
        if(o == null) {
            throw new NullPointerException();
        }
    }
    public void checkForValidIndex(int idx) {
        if(idx == -1){
            throw new IllegalArgumentException();
        }
    }
}
public class E10_SortedSet {
    public static void main(String[] args) {

    }
}
