package co.edu.uniquindio.LaboratorioListas;

/**
 * Lógica del juego por turnos.
 * Gestiona jugadores usando una ListaDobleCircular<Jugador>.
 */
public class JuegoTurnos {

    private ListaDobleCircular<Jugador> mesa = new ListaDobleCircular<>();
    private int posActual = 0;

    public void agregar(String nombre) {
        Jugador jugador = new Jugador(nombre);
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

    public void expulsar(String nombre) {
        if (mesa.estaVacia()) {
            System.out.println("Sin jugadores.");
            return;
        }
        Jugador buscar = new Jugador(nombre);
        int pos = mesa.buscar(buscar);
        if (pos == -1) {
            System.out.println("No encontrado: " + nombre);
            return;
        }
        mesa.eliminar(buscar);
        if (mesa.estaVacia()) {
            posActual = 0;
        } else if (posActual >= mesa.getTamanio()) {
            posActual = 0;
        }
        System.out.println(nombre + " expulsado. Quedan " + mesa.getTamanio());
    }

    public void buscar(String nombre) {
        Jugador buscar = new Jugador(nombre);
        int pos = mesa.buscar(buscar);
        if (pos == -1) System.out.println("No encontrado: " + nombre);
        else System.out.println("Encontrado en posición " + (pos + 1) + ": " + nombre);
    }

    public void sumarPuntos(String nombre, int puntos) {
        Jugador buscar = new Jugador(nombre);
        int pos = mesa.buscar(buscar);
        if (pos == -1) {
            System.out.println("Jugador no encontrado: " + nombre);
            return;
        }
        mesa.obtenerValorNodo(pos).sumarPuntos(puntos);
        System.out.println("Puntos sumados a " + nombre + ": +" + puntos);
    }

    public Jugador jugadorActual() {
        if (mesa.estaVacia()) return null;
        return mesa.obtenerValorNodo(posActual);
    }

    public void mostrar() {
        if (mesa.estaVacia()) {
            System.out.println("Sin jugadores.");
            return;
        }
        System.out.println("Mesa de juego:");
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
