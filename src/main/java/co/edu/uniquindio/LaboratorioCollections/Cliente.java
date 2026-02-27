package co.edu.uniquindio.LaboratorioCollections;

public class Cliente {

    private final int turno;
    private String nombre;

    public Cliente(int turno, String nombre) {
        this.turno = turno;
        this.nombre = nombre;
    }

    public int getTurno() {
        return turno;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Turno: " + turno + " | Nombre: " + nombre;
    }
}