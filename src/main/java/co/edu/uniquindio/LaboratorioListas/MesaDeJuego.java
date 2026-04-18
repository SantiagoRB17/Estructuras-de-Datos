package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa la mesa de juego.
 * Orquesta la partida: registra jugadores, gestiona los turnos
 * de forma circular, expulsa jugadores y consulta el estado.
 */
public class MesaDeJuego {

    private String nombreJuego;
    private JuegoTurnos juego;

    public MesaDeJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
        this.juego = new JuegoTurnos();
    }

    /**
     * Registra un nuevo jugador en la mesa.
     */
    public void registrarJugador(String nombre) {
        System.out.println("Registrando jugador: " + nombre);
        juego.agregar(nombre);
    }

    /**
     * Avanza al turno del siguiente jugador.
     */
    public void siguienteTurno() {
        System.out.println("Avanzando turno...");
        juego.siguienteTurno();
    }

    /**
     * Consulta quién jugó en el turno anterior.
     */
    public void turnoAnterior() {
        System.out.println("Turno anterior:");
        juego.turnoAnterior();
    }

    /**
     * Expulsa un jugador de la partida.
     */
    public void expulsarJugador(String nombre) {
        System.out.println("Expulsando a: " + nombre);
        juego.expulsar(nombre);
    }

    /**
     * Suma puntos al jugador indicado.
     */
    public void sumarPuntos(String nombre, int puntos) {
        System.out.println("Sumando " + puntos + " puntos a " + nombre);
        juego.sumarPuntos(nombre, puntos);
    }

    /**
     * Busca un jugador en la mesa.
     */
    public void buscarJugador(String nombre) {
        System.out.println("Buscando jugador: " + nombre);
        juego.buscar(nombre);
    }

    /**
     * Muestra el estado actual de la mesa: turno activo, anterior y siguiente.
     */
    public void mostrarEstado() {
        System.out.println("Estado de la mesa:");
        juego.infoActual();
    }

    /**
     * Muestra todos los jugadores en la mesa.
     */
    public void mostrarJugadores() {
        System.out.println("Jugadores en la mesa:");
        juego.mostrar();
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public static void main(String[] args) {
        MesaDeJuego mesa = new MesaDeJuego("Uno");

        mesa.registrarJugador("Carlos");
        mesa.registrarJugador("Sofía");
        mesa.registrarJugador("Tomás");
        mesa.registrarJugador("Valeria");

        mesa.mostrarJugadores();
        mesa.mostrarEstado();

        mesa.siguienteTurno();
        mesa.sumarPuntos("Sofía", 10);

        mesa.siguienteTurno();
        mesa.sumarPuntos("Tomás", 5);

        mesa.siguienteTurno();
        mesa.siguienteTurno(); 

        mesa.mostrarEstado();
        mesa.expulsarJugador("Tomás");

        mesa.mostrarJugadores();
        mesa.buscarJugador("Sofía");
    }
}
