package co.edu.uniquindio.ListasEnlazadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaCircularDoblementeEnlazada implements Iterable<Integer> {
    private NodoDoble head;
    private NodoDoble tail;
    private int size;

    public ListaCircularDoblementeEnlazada() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data) {
        NodoDoble newNode = new NodoDoble(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrev(tail);
            tail.setNext(newNode);
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
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
        } else {
            newNode.setPrev(tail);
            newNode.setNext(head);
            tail.setNext(newNode);
            head.setPrev(newNode);
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
            size = 0;
            return;
        }

        head = head.getNext();
        head.setPrev(tail);
        tail.setNext(head);
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
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
        return size == 0;
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
        if (isEmpty()) {
            return -1;
        }

        NodoDoble current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData() == data) {
                return i;
            }
            current = current.getNext();
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
        for (int i = 0; i < size; i++) {
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
            for (int j = 0; j < size - 1; j++) {
                NodoDoble next = current.getNext();
                if (current.getData() > next.getData()) {
                    int aux = current.getData();
                    current.setData(next.getData());
                    next.setData(aux);
                }
                current = current.getNext();
            }
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodoDoble current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
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
        private int count = 0;
        private NodoDoble current = head;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            int data = current.getData();
            current = current.getNext();
            count++;
            return data;
        }
    }
}
