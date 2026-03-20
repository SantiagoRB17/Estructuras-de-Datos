package co.edu.uniquindio.ListasEnlazadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoblementeEnlazada implements Iterable<Integer> {
    private NodoDoble head;
    private NodoDoble tail;
    private int size;

    public ListaDoblementeEnlazada() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data) {
        NodoDoble newNode = new NodoDoble(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        NodoDoble newNode = new NodoDoble(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.getNext();
        head.setPrev(null);
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        tail = tail.getPrev();
        tail.setNext(null);
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        NodoDoble current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getNodeValue(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        NodoDoble current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public int getNodePosition(int data) {
        NodoDoble current = head;
        int pos = 0;

        while (current != null) {
            if (current.getData() == data) {
                return pos;
            }
            current = current.getNext();
            pos++;
        }
        return -1;
    }

    public boolean isValid(int index) {
        return index >= 0 && index < size;
    }

    public void modifyNode(int oldData, int newData) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        NodoDoble current = head;
        while (current != null) {
            if (current.getData() == oldData) {
                current.setData(newData);
                return;
            }
            current = current.getNext();
        }

        throw new RuntimeException("Node not found");
    }

    public void sort() {
        if (isEmpty() || size == 1) {
            return;
        }

        for (int i = 0; i < size; i++) {
            NodoDoble current = head;
            while (current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    int aux = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(aux);
                }
                current = current.getNext();
            }
        }
    }

    public void printList() {
        NodoDoble dummy = head;
        while (dummy != null) {
            System.out.print(dummy.getData() + " ");
            dummy = dummy.getNext();
        }
        System.out.println();
    }

    public void removeList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListaIterador();
    }

    private class ListaIterador implements Iterator<Integer> {
        private NodoDoble current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            int data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
