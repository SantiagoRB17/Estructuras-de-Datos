package co.edu.uniquindio.LaboratorioListas;

/**
 * Escenario 1 - Sistema de turnos en una panadería.
 * Usa ListaSimple con objetos Cliente en lugar de Strings.
 */
public class SistemaTurnos {

    private ListaSimple<Cliente> cola;
    private int contadorTurnos;

    public SistemaTurnos() {
        cola = new ListaSimple<>();
        contadorTurnos = 0;
    }

    public void agregar(String nombre) {
        contadorTurnos++;
        Cliente cliente = new Cliente(nombre, contadorTurnos);
        cola.agregarfinal(cliente);
        System.out.println("Turno " + contadorTurnos + " asignado a: " + nombre);
    }

    public void atender() {
        if (cola.estaVacia()) {
            System.out.println("No hay clientes en espera.");
            return;
        }
        Cliente cliente = cola.obtenerValorNodo(0);
        cola.eliminarPrimero();
        System.out.println("Atendiendo: " + cliente.getNombre()
                + " (turno " + cliente.getNumeroTurno() + ")");
    }

    public void siguiente() {
        if (cola.estaVacia()) {
            System.out.println("No hay clientes en espera.");
            return;
        }
        Cliente cliente = cola.obtenerValorNodo(0);
        System.out.println("Siguiente: " + cliente.getNombre()
                + " (turno " + cliente.getNumeroTurno() + ")");
    }

    public void mostrar() {
        if (cola.estaVacia()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.println("Turnos en espera:");
        cola.imprimirLista();
    }
}
