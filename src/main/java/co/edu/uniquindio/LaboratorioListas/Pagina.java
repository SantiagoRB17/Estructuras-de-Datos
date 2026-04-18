package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa una página web visitada en el navegador.
 * Guarda la URL y el título de la página.
 */
public class Pagina {

    private String url;
    private String titulo;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    public Pagina(String url) {
        this.url = url;
        this.titulo = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pagina{url='" + url + "', titulo='" + titulo + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagina)) return false;
        Pagina p = (Pagina) o;
        return url.equals(p.url);
    }
}
