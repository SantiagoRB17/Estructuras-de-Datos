package co.edu.uniquindio.ListasEnlazadas;


public class ListaInvertirContenido {

    public void invertirLista(ListaEnlazadaSimple lista, Nodo current, Nodo prev){
        if (lista.isEmpty() || lista.size == 1){
            return;
        }
        

    }

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        ListaInvertirContenido listaInverti = new ListaInvertirContenido();
        lista.printList();

    }

}
