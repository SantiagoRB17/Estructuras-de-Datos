package co.edu.uniquindio.LaboratorioListas;

public class Escenario4 {

    static class JuegoTurnos {

        private ListaDobleCircular<String> mesa = new ListaDobleCircular<>();
        private int posActual = 0;

        public void agregar(String jugador) {
            mesa.agregarFinal(jugador);
            System.out.println("Jugador agregado: " + jugador);
        }

        public void siguienteTurno() {
            if (mesa.estaVacia()) {
                System.out.println("Sin jugadores.");
                return;
            }
            posActual = (posActual + 1) % mesa.getTamanio();
            System.out.println("Turno de: " + jugadorActual());
        }

        public void turnoAnterior() {
            if (mesa.estaVacia()) {
                System.out.println("Sin jugadores.");
                return;
            }
            posActual = (posActual - 1 + mesa.getTamanio()) % mesa.getTamanio();
            System.out.println("Jugador anterior: " + jugadorActual());
        }

        public void expulsar(String jugador) {
            if (mesa.estaVacia()) {
                System.out.println("Sin jugadores.");
                return;
            }

            int pos = mesa.buscar(jugador);
            if (pos == -1) {
                System.out.println("No encontrado: " + jugador);
                return;
            }

            mesa.eliminar(jugador);

            if (mesa.estaVacia()) {
                posActual = 0;
            } else if (posActual >= mesa.getTamanio()) {
                posActual = 0;
            }

            System.out.println(jugador + " expulsado. Quedan " + mesa.getTamanio());
        }

        public void buscar(String jugador) {
            int pos = mesa.buscar(jugador);
            if (pos == -1) {
                System.out.println("No encontrado: " + jugador);
            } else {
                System.out.println("Encontrado en posición " + (pos + 1) + ": " + jugador);
            }
        }

        private String jugadorActual() {
            if (mesa.estaVacia()) {
                return null;
            }
            return mesa.obtenerValorNodo(posActual);
        }

        public void mostrar() {
            if (mesa.estaVacia()) {
                System.out.println("Sin jugadores.");
                return;
            }
            System.out.println("Mesa de juego");
            mesa.imprimirLista();
        }

        public void infoActual() {
            if (mesa.estaVacia()) {
                System.out.println("Sin jugadores.");
                return;
            }

            System.out.println("Turno activo:  " + jugadorActual());
            int ant = (posActual - 1 + mesa.getTamanio()) % mesa.getTamanio();
            int sig = (posActual + 1) % mesa.getTamanio();
            System.out.println("Jugó antes:    " + mesa.obtenerValorNodo(ant));
            System.out.println("Juega después: " + mesa.obtenerValorNodo(sig));
        }
    }

    public static void main(String[] args) {
        JuegoTurnos juego = new JuegoTurnos();

        juego.agregar("Carlos");
        juego.agregar("Sofía");
        juego.agregar("Tomás");
        juego.agregar("Valeria");

        juego.mostrar();
        juego.infoActual();

        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();

        juego.expulsar("Tomás");
        juego.mostrar();
        juego.buscar("Sofía");
    }
}
