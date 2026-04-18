package co.edu.uniquindio.LaboratorioListas;

/**
 * Clase de dominio que representa un cliente en la panadería.
 * Cada cliente tiene un nombre y un número de turno asignado al llegar.
 */
public class Cliente {

    private String nombre;
    private int numeroTurno;

    public Cliente(String nombre, int numeroTurno) {
        this.nombre = nombre;
        this.numeroTurno = numeroTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', turno=" + numeroTurno + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente c = (Cliente) o;
        return numeroTurno == c.numeroTurno && nombre.equals(c.nombre);
    }
}
