package co.edu.uniquindio.ListasEnlazadas;


public class ListaInvertirContenido {

    public void listaInvertirContenido(ListaEnlazadaSimple lista) {
        if (lista.isEmpty() || lista.size == 1){
            return;
        }
        lista.head = invertirLista(lista.head,null);
    }

    public Nodo invertirLista(Nodo current, Nodo prev){

        if (current == null){
            return prev;
        }

        Nodo next= current.getNext();
        current.setNext(prev);

        return invertirLista(next,current);
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        System.out.println("Lista original: ");
        lista.printList();
        System.out.println("Lista invertida: ");
        ListaInvertirContenido listaInverti = new ListaInvertirContenido();
        listaInverti.listaInvertirContenido(lista);
        lista.printList();

    }

}
