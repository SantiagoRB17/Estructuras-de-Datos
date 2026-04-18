package co.edu.uniquindio.LaboratorioListas;

/**
 * Lógica de la lista de reproducción circular.
 * Gestiona canciones usando una ListaSimpleCircular<Cancion>.
 */
public class Playlist {

    private ListaSimpleCircular<Cancion> lista = new ListaSimpleCircular<>();
    private Cancion actual = null;
    private int posActual = 0;

    public void agregar(String titulo, String artista) {
        Cancion cancion = new Cancion(titulo, artista);
        lista.agregarfinal(cancion);
        if (actual == null) actual = cancion;
        System.out.println("Agregada: " + cancion);
    }

    public void agregar(String titulo) {
        agregar(titulo, "Desconocido");
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

    public void eliminar(String titulo) {
        if (lista.estaVacia()) {
            System.out.println("Lista vacía.");
            return;
        }
        Cancion buscar = new Cancion(titulo);
        int pos = lista.obtenerPosicionNodo(buscar);
        if (pos == -1) {
            System.out.println("No encontrada: " + titulo);
            return;
        }
        boolean eraActual = buscar.equals(actual);
        lista.eliminar(buscar);
        System.out.println("Eliminada: " + titulo);
        if (lista.estaVacia()) {
            actual = null;
            posActual = 0;
            return;
        }
        posActual = posActual % lista.getTamanio();
        if (eraActual) actual = lista.obtenerValorNodo(posActual);
    }

    public void buscar(String titulo) {
        Cancion buscar = new Cancion(titulo);
        int pos = lista.obtenerPosicionNodo(buscar);
        if (pos == -1) System.out.println("No encontrada: " + titulo);
        else System.out.println("Encontrada en posición " + (pos + 1) + ": " + titulo);
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
