package co.edu.uniquindio.LaboratorioListas;

public class Historial {
    private ListaDoble<String> paginas;
    private int indice;

    public Historial() {
        paginas = new ListaDoble<>();
        indice = -1;
    }

    public String paginaActual() {
        if (indice < 0) {
            throw new IndexOutOfBoundsException("No hay páginas en el historial.");
        }
        return paginas.obtener(indice);
    }

    public void agregar(String pagina) {
        limpiarHistorialDeAvance();
        paginas.agregarfinal(pagina);
        indice = paginas.getTamanio() - 1;

    }

    public String regresar() {

        if (indice <= 0) {
            throw new IndexOutOfBoundsException(
                    "No hay páginas anteriores para regresar."
            );
        }
        indice--;
        return paginas.obtener(indice);
    }

    public String avanzar() {
        if (indice >= paginas.getTamanio()) {
            throw new IndexOutOfBoundsException(
                    "No hay páginas siguientes para avanzar."
            );
        }
        indice++;
        return paginas.obtener(indice);
    }

    public void consultarHistorial() {
        for (String pagina : paginas) {
            System.out.println(pagina + "\n");
        }
    }

    private void limpiarHistorialDeAvance() {
        while (paginas.getTamanio() - 1 >  indice) {
            paginas.eliminarUltimo();
        }
    }

    private void buscar(String pagina) {
        int pos = paginas.obtenerPosicionNodo(pagina);
        if (pos == -1) System.out.println("No encontrada: " + pagina);
        else System.out.println("Encontrada en posición " + (pos + 1) + ": " + pagina);
    }

    public void visitar(String pagina) {
        limpiarHistorialDeAvance();
        paginas.agregarfinal(pagina);
        indice = 0;
        System.out.println("Visitando: " + pagina);
    }


    public static void main(String[] args) {
        Historial h = new Historial();
        h.agregar("google.com");
        h.agregar("wikipedia.org");
        h.agregar("github.com");
        h.consultarHistorial();

        System.out.println("Pagina actual: " + h.paginaActual());
        System.out.println("Pagina anterior: " + h.regresar());
        System.out.println("Pagina anterior: " + h.regresar());
        System.out.println("Pagina siguiente: " + h.avanzar());

        h.buscar("google.com");

        h.visitar("openai.com");
        h.consultarHistorial();

    }
}














