package co.edu.uniquindio.LaboratorioListas;

import java.util.Iterator;

public class Escenario3 {
    static class Playlist {
        private ListaSimpleCircular<String> lista = new ListaSimpleCircular<>();
        private String actual = null;
        private int posActual = 0;

        public void agregar(String cancion) {
            lista.agregarfinal(cancion);
            if (actual == null) actual = cancion;
            System.out.println("Agregada: " + cancion);
        }

        public void siguiente() {
            if (lista.estaVacia()) {
                System.out.println("Lista vacía.");
                return;
            }
            posActual = (posActual + 1) % lista.getTamanio();
            actual = lista.obtenerValorNodo(posActual);
            System.out.println("Reproduciendo: " + actual);
        }

        public void eliminar(String cancion) {
            if (lista.estaVacia()) {
                System.out.println("Lista vacía.");
                return;
            }
            boolean eraActual = cancion.equals(actual);
            lista.eliminar(cancion);
            System.out.println("Eliminada: " + cancion);
            if (lista.estaVacia()) {
                actual = null;
                posActual = 0;
                return;
            }
            posActual = posActual % lista.getTamanio();
            if (eraActual) actual = lista.obtenerValorNodo(posActual);
        }

        public void buscar(String cancion) {
            int pos = lista.obtenerPosicionNodo(cancion);
            if (pos == -1) System.out.println("No encontrada: " + cancion);
            else System.out.println("Encontrada en posición " + (pos + 1) + ": " + cancion);
        }

        public void mostrar() {
            if (lista.estaVacia()) {
                System.out.println("Lista vacía.");
                return;
            }
            System.out.println("Playlist:");
            lista.imprimirLista();
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.agregar("Canción A");
        p.agregar("Canción B");
        p.agregar("Canción C");
        p.agregar("Canción D");
        p.mostrar();

        p.siguiente();
        p.siguiente();
        p.eliminar("Canción C");
        p.mostrar();

        p.siguiente();
        p.siguiente();
        p.buscar("Canción B");
    }
}
