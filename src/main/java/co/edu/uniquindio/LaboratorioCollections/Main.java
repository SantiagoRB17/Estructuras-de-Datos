package co.edu.uniquindio.LaboratorioCollections;

public class Main {

    public static void main(String[] args) {

        SistemaTurnos sistema = new SistemaTurnos();

        // Registrar
        sistema.registrarCliente("Carlos");
        sistema.registrarCliente("Ana");
        sistema.registrarCliente("Luis");

        System.out.println("Clientes en espera: " + sistema.cantidadEnEspera());

        System.out.println("Siguiente a atender: " + sistema.verSiguiente());

        System.out.println("\nAtendiendo...");
        System.out.println("Atendido: " + sistema.atenderCliente());

        System.out.println("\nClientes en espera: " + sistema.cantidadEnEspera());

        System.out.println("\nAtendiendo todos...");
        while (!sistema.estaVacia()) {
            System.out.println("Atendido: " + sistema.atenderCliente());
        }

        System.out.println("\n¿La fila está vacía? " + sistema.estaVacia());
    }
}