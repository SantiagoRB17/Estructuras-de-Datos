package co.edu.uniquindio.ListasEnlazadas;

public class Nodo {
    private int data;
    private Nodo next;

    public Nodo(int data) {
        this.data = data;
        next =null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
