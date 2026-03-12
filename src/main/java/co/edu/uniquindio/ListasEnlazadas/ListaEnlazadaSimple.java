package co.edu.uniquindio.ListasEnlazadas;

import org.w3c.dom.Node;

public class ListaEnlazadaSimple {
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
            size++;
            return;
        }
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Nodo newNode = new Nodo(data);
        Nodo current = head;
        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        } else {
            while (head.getNext() != null) {
                current = head.getNext();
            }
            current.setNext(newNode);
            size++;
        }

    }

    public void removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        head = head.getNext();
        size--;

    }
    public void removeLast(){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
    }
    public void remove(int index){
        if(isEmpty() || index < 0 || index >= size){
            throw new RuntimeException("List is empty");
        }
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size-1){
            removeLast();
            return;
        }
        Nodo current = head;
        int i = 0;
        while(current.getNext() != null && i < index){
            current = current.getNext();
            i++;
        }
        if(current.getNext().getNext() == null){
            current.setNext(null);
        }else{
            current.setNext(current.getNext().getNext());
        }

    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(5);
        lista.add(8);
        lista.add(3);
        System.out.println(lista.head.getData());
    }
}