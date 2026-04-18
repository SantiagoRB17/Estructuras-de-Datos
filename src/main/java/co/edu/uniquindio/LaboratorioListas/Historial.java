package co.edu.uniquindio.LaboratorioListas;

/**
 * Escenario 2 - Historial de navegación de un navegador web.
 * Usa ListaDoble con objetos Pagina en lugar de Strings.
 */
public class Historial {

    private ListaDoble<Pagina> paginas;
    private int indice;

    public Historial() {
        paginas = new ListaDoble<>();
        indice = -1;
    }

    public Pagina paginaActual() {
        if (indice < 0) {
            throw new IndexOutOfBoundsException("No hay páginas en el historial.");
        }
        return paginas.obtener(indice);
    }

    public void agregar(String url, String titulo) {
        limpiarHistorialDeAvance();
        Pagina pagina = new Pagina(url, titulo);
        paginas.agregarfinal(pagina);
        indice = paginas.getTamanio() - 1;
    }

    public void agregar(String url) {
        agregar(url, url);
    }

    public Pagina regresar() {
        if (indice <= 0) {
            throw new IndexOutOfBoundsException("No hay páginas anteriores para regresar.");
        }
        indice--;
        return paginas.obtener(indice);
    }

    public Pagina avanzar() {
        if (indice >= paginas.getTamanio() - 1) {
            throw new IndexOutOfBoundsException("No hay páginas siguientes para avanzar.");
        }
        indice++;
        return paginas.obtener(indice);
    }

    public void visitar(String url, String titulo) {
        limpiarHistorialDeAvance();
        Pagina pagina = new Pagina(url, titulo);
        paginas.agregarfinal(pagina);
        indice = paginas.getTamanio() - 1;
        System.out.println("Visitando: " + pagina);
    }

    public void visitar(String url) {
        visitar(url, url);
    }

    public void buscar(String url) {
        Pagina buscar = new Pagina(url);
        int pos = paginas.obtenerPosicionNodo(buscar);
        if (pos == -1) System.out.println("No encontrada: " + url);
        else System.out.println("Encontrada en posición " + (pos + 1) + ": " + url);
    }

    public void consultarHistorial() {
        for (Pagina pagina : paginas) {
            System.out.println(pagina);
        }
    }

    private void limpiarHistorialDeAvance() {
        while (paginas.getTamanio() - 1 > indice) {
            paginas.eliminarUltimo();
        }
    }
}
