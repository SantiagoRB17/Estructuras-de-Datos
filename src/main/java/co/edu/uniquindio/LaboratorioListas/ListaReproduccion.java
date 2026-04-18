package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa la lista de reproducción de música.
 * Orquesta la playlist circular: agrega, elimina, avanza canciones
 * y muestra el estado actual de la reproducción.
 */
public class ListaReproduccion {

    private String nombre;
    private Playlist playlist;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.playlist = new Playlist();
    }

    /**
     * Agrega una canción a la lista de reproducción.
     */
    public void agregarCancion(String titulo, String artista) {
        System.out.println("Agregando canción...");
        playlist.agregar(titulo, artista);
    }

    public void agregarCancion(String titulo) {
        agregarCancion(titulo, "Desconocido");
    }

    /**
     * Avanza a la siguiente canción en la lista (circular).
     */
    public void siguiente() {
        System.out.println("Siguiente canción:");
        playlist.siguiente();
    }

    /**
     * Elimina una canción de la lista por su título.
     */
    public void eliminarCancion(String titulo) {
        System.out.println("Eliminando: " + titulo);
        playlist.eliminar(titulo);
    }

    /**
     * Busca una canción en la lista por su título.
     */
    public void buscarCancion(String titulo) {
        System.out.println("Buscando: " + titulo);
        playlist.buscar(titulo);
    }

    /**
     * Muestra todas las canciones en la lista.
     */
    public void mostrar() {
        System.out.println("Canciones en la lista:");
        playlist.mostrar();
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        ListaReproduccion lista = new ListaReproduccion("Youtube Music");

        lista.agregarCancion("Canción A", "Artista 1");
        lista.agregarCancion("Canción B", "Artista 2");
        lista.agregarCancion("Canción C", "Artista 3");
        lista.agregarCancion("Canción D", "Artista 1");

        lista.mostrar();

        lista.siguiente();
        lista.siguiente();

        lista.eliminarCancion("Canción C");
        lista.mostrar();

        lista.siguiente();
        lista.siguiente();
        lista.siguiente();

        lista.buscarCancion("Canción B");
    }
}
