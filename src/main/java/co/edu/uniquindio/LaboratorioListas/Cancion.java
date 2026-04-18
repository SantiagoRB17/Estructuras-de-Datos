package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa una canción en la lista de reproducción.
 * Contiene el título y el artista de la canción.
 */
public class Cancion {

    private String titulo;
    private String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public Cancion(String titulo) {
        this.titulo = titulo;
        this.artista = "Desconocido";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Cancion{titulo='" + titulo + "', artista='" + artista + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cancion)) return false;
        Cancion c = (Cancion) o;
        return titulo.equals(c.titulo);
    }
}
