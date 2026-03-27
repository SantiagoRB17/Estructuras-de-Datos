package co.edu.uniquindio.LaboratorioListas;

import java.util.Iterator;

public class Escenario3 {
        public static void main(String[] args) {

            ListaCircularSimplementeEnlazada playlist = new ListaCircularSimplementeEnlazada();

            playlist.add("Canción A");
            playlist.add("Canción B");
            playlist.add("Canción C");
            playlist.add("Canción D");

            playlist.printList();

            System.out.println("Siguiente: ");
            Iterator it = playlist.iterator();
            System.out.println(it.next());
            System.out.println(it.next());

            System.out.println("Eliminar cancion: ");
            playlist.remove(2);
            playlist.printList();

            System.out.println("Buscar cancion: ");
            System.out.println("Cancion encontrada: " + playlist.getNodeValue(0));
            System.out.println("Cancion encontrada: " + playlist.getNodeValue(1));
    }
}
