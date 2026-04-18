package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa la panadería.
 * Orquesta el sistema de turnos: registra clientes,
 * atiende en orden de llegada y muestra el estado de la cola.
 */
public class Panaderia {

    private String nombre;
    private SistemaTurnos sistemaTurnos;

    public Panaderia(String nombre) {
        this.nombre = nombre;
        this.sistemaTurnos = new SistemaTurnos();
    }

    /**
     * Un cliente llega a la panadería y recibe un turno.
     */
    public void recibirCliente(String nombreCliente) {
        System.out.println("Cliente llega: " + nombreCliente);
        sistemaTurnos.agregar(nombreCliente);
    }

    /**
     * Se atiende al siguiente cliente en la cola.
     */
    public void atenderSiguiente() {
        System.out.println("Llamando al siguiente turno...");
        sistemaTurnos.atender();
    }

    /**
     * Consulta quién es el próximo sin atenderlo aún.
     */
    public void consultarSiguiente() {
        System.out.println("Próximo en fila:");
        sistemaTurnos.siguiente();
    }

    /**
     * Muestra todos los clientes actualmente en espera.
     */
    public void mostrarFila() {
        System.out.println("Estado actual de la fila:");
        sistemaTurnos.mostrar();
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia("PanTolima");

        panaderia.recibirCliente("Ana");
        panaderia.recibirCliente("Luis");
        panaderia.recibirCliente("Pedro");
        panaderia.recibirCliente("María");

        panaderia.mostrarFila();
        panaderia.consultarSiguiente();

        panaderia.atenderSiguiente();
        panaderia.atenderSiguiente();

        panaderia.mostrarFila();
        panaderia.consultarSiguiente();
    }
}
