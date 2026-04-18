package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa el navegador web.
 * Orquesta el historial de páginas visitadas, permitiendo
 * avanzar, retroceder y visitar nuevas páginas.
 */
public class Navegador {

    private String nombre;
    private Historial historial;

    public Navegador(String nombre) {
        this.nombre = nombre;
        this.historial = new Historial();
    }

    /**
     * Visita una nueva página, limpiando el historial de avance.
     */
    public void visitar(String url, String titulo) {
        System.out.println("Visitando: " + url);
        historial.agregar(url, titulo);
    }

    public void visitar(String url) {
        visitar(url, url);
    }

    /**
     * Regresa a la página anterior en el historial.
     */
    public void retroceder() {
        try {
            Pagina pagina = historial.regresar();
            System.out.println("Retrocediendo a: " + pagina);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No hay páginas anteriores.");
        }
    }

    /**
     * Avanza a la página siguiente si había retrocedido antes.
     */
    public void avanzar() {
        try {
            Pagina pagina = historial.avanzar();
            System.out.println("Avanzando a: " + pagina);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No hay páginas siguientes.");
        }
    }

    /**
     * Muestra la página que se está viendo actualmente.
     */
    public void paginaActual() {
        try {
            Pagina pagina = historial.paginaActual();
            System.out.println("Página actual: " + pagina);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No hay página actual.");
        }
    }

    /**
     * Muestra todo el historial de páginas visitadas
     */
    public void mostrarHistorial() {
        System.out.println("Historial completo:");
        historial.consultarHistorial();
    }

    /**
     * Busca una URL en el historial.
     */
    public void buscar(String url) {
        System.out.println("Buscando en historial: " + url);
        historial.buscar(url);
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        Navegador navegador = new Navegador("Navegador");

        navegador.visitar("google.com", "Google");
        navegador.visitar("wikipedia.org", "Wikipedia");
        navegador.visitar("github.com", "GitHub");

        navegador.paginaActual();
        navegador.mostrarHistorial();

        navegador.retroceder();
        navegador.retroceder();
        navegador.paginaActual();

        navegador.avanzar();
        navegador.paginaActual();

        navegador.buscar("google.com");

        navegador.visitar("openai.com", "OpenAI");
        navegador.avanzar();
        navegador.mostrarHistorial();
    }
}
