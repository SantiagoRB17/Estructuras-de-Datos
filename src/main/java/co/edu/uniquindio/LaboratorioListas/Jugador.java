package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa un jugador en el juego por turnos.
 * Tiene un nombre y un puntaje acumulado durante la partida.
 */
public class Jugador {

    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    @Override
    public String toString() {
        return "Jugador{nombre='" + nombre + "', puntaje=" + puntaje + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador j = (Jugador) o;
        return nombre.equals(j.nombre);
    }
}
