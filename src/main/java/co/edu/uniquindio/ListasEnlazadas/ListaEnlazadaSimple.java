package co.edu.uniquindio.ListasEnlazadas;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazadaSimple{
    Nodo head;
    int size;

    public ListaEnlazadaSimple() {
        head = null;
        size = 0;
    }

    public void add(int data) {
        Nodo newNode = new Nodo(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Nodo newNode = new Nodo(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Nodo current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        head = head.getNext();
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            size--;
            return;
        }

        Nodo current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        current.setNext(null);
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

        Nodo current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        size--;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getNodeValue(int index){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        if(index < 0 || index >= size){
            throw new RuntimeException("Index out of bounds");
        }
        Nodo current = head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getData();
    }
    public int getNodePosition(int data){
        Nodo current = head;
        int pos = 0;
        while(current != null){
            if(current.getData() == data){
                return pos;
            }
            pos++;
            current = current.getNext();
        }
        return -1;
    }
    public boolean isValid(int index){
        return index >= 0 && index < size;
    }
    public void modifyNode(int data){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        Nodo current = head;
        for(int i = 0; i < size; i++){
            if(current.getData() == data){
                current.setData(data);
                return;
            }
            current = current.getNext();
        }
    }
    public void sort(){
        for (int i = 0; i < size; i++){
            Nodo current = head;
            while (current.getNext() != null){
                if (current.getData() > current.getNext().getData()){
                    int aux = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(aux);
                }
                current = current.getNext();
            }
        }
    }
    public void printList(){
        Nodo dummy = head;
        while(dummy != null){
            System.out.print(dummy.getData() + " ");
            dummy = dummy.getNext();
        }
    }
    public void removeList(){
        head = null;
        size = 0;
    }


    public boolean hasNext() {
        return head != null;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay mas elementos en la lista");
        }
        int aux = head.getData();
        head = head.getNext();
        return aux;
    }
}

class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(5);
        lista.add(8);
        lista.add(3);
        lista.add(1);

        lista.sort();
        lista.printList();

        System.out.println();

        while (lista.hasNext()){
            System.out.println(lista.next());
        }
    }
}