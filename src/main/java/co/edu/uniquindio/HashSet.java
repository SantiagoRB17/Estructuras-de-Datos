package co.edu.uniquindio;

import java.util.LinkedList;

public class HashSet<E> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<E>[] table;
    private int size;


    public HashSet() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    private int getIndex(E element) {
        int hash = element.hashCode();
        return Math.abs(hash) % INITIAL_CAPACITY;
    }

    private boolean add(E element){
        if(contains(element)){
            return false;
        }
        int index = getIndex(element);
        if(table[index] == null){
            table[index] = new LinkedList<>();
        }
        table[index].add(element);
        size++;
        return true;

    }
    private boolean contains(E element){
        int index = getIndex(element);

        if(table[index] == null){
            return false;
        }
        return table[index].contains(element);
    }
    public boolean remove(E element) {

        int index = getIndex(element);

        if (table[index] == null) {
            return false;
        }

        boolean removed = table[index].remove(element);

        if (removed) {
            size--;
        }

        return removed;
    }


}
