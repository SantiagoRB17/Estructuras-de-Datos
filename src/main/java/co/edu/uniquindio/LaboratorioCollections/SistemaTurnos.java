package co.edu.uniquindio.LaboratorioCollections;

import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnos {

    private Queue<Cliente> fila = new LinkedList<>();
    private int contadorTurnos = 1;

    public void registrarCliente(String nombre) {
        Cliente nuevo = new Cliente(contadorTurnos++, nombre);
        fila.add(nuevo);
    }


    public Cliente atenderCliente() {
        if (fila.isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return null;
        }
        return fila.poll();
    }


    public Cliente verSiguiente() {
        return fila.peek();
    }


    public int cantidadEnEspera() {
        return fila.size();
    }
    public boolean estaVacia() {
        return fila.isEmpty();
    }
}
