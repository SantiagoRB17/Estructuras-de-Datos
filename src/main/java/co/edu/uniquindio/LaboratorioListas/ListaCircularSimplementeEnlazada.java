package co.edu.uniquindio.LaboratorioListas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaCircularSimplementeEnlazada<T extends Comparable<? super T>> implements Iterable<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public ListaCircularSimplementeEnlazada() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Nodo<T> newNode = new Nodo<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(head);
            tail.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Nodo<T> newNode = new Nodo<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(head);
            tail.setNext(newNode);
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

        Nodo<T> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        current.setNext(head);
        tail = current;
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

        Nodo<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getNodeValue(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        Nodo<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public int getNodePosition(T data) {
        if (isEmpty()) {
            return -1;
        }

        Nodo<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public boolean isValid(int index) {
        return index >= 0 && index < size;
    }

    public void modifyNode(T oldData, T newData) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        Nodo<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(oldData)) {
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
            Nodo<T> current = head;
            for (int j = 0; j < size - 1; j++) {
                Nodo<T> next = current.getNext();
                if (current.getData().compareTo(next.getData()) > 0) {
                    T aux = current.getData();
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

        Nodo<T> current = head;
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
    public Iterator<T> iterator() {
        return new ListaIterador();
    }

    private class ListaIterador implements Iterator<T> {
        private int count = 0;
        private Nodo<T> current = head;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            T data = current.getData();
            current = current.getNext();
            count++;
            return data;
        }
    }
}
