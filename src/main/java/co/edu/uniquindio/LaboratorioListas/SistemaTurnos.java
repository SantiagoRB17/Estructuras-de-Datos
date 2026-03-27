package co.edu.uniquindio.LaboratorioListas;

public class SistemaTurnos {


    private static class Nodo {
        String cliente;
        int    turno;
        Nodo   next;

        Nodo(String cliente, int turno) {
            this.cliente = cliente;
            this.turno   = turno;
            this.next    = null;
        }
    }


    private static class Lista {
        private Nodo head;
        private Nodo tail;
        private int  size;
        private int  contadorTurnos;


        public void agregar(String cliente) {
            contadorTurnos++;
            Nodo nuevo = new Nodo(cliente, contadorTurnos);
            if (head == null) {
                head = tail = nuevo;
            } else {
                tail.next = nuevo;
                tail      = nuevo;
            }
            size++;
            System.out.println("Turno " + contadorTurnos + " asignado a: " + cliente);
        }


        public void eliminar() {
            if (head == null) {
                System.out.println("No hay clientes en espera.");
                return;
            }
            System.out.println("Atendiendo: " + head.cliente
                    + " (turno " + head.turno + ")");
            head = head.next;
            if (head == null) tail = null;
            size--;
        }


        public void buscar() {
            if (head == null) {
                System.out.println("No hay clientes en espera.");
            } else {
                System.out.println("Siguiente: " + head.cliente
                        + " (turno " + head.turno + ")");
            }
        }


        public void mostrar() {
            if (head == null) {
                System.out.println("Cola vacía.");
                return;
            }
            System.out.print("Turnos en espera: ");
            Nodo actual = head;
            while (actual != null) {
                System.out.print("[" + actual.turno + "] " + actual.cliente);
                if (actual.next != null) System.out.print(" -> ");
                actual = actual.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Lista cola = new Lista();

        cola.agregar("Ana");
        cola.agregar("Luis");
        cola.agregar("Pedro");
        cola.agregar("María");

        cola.mostrar();
        cola.buscar();
        cola.eliminar();
        cola.eliminar();
        cola.mostrar();
        cola.buscar();
    }
}
