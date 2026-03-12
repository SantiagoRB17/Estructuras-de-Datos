package co.edu.uniquindio.TallerCollectionsGenerics;

import java.time.LocalDate;

public class Tarea<T> implements Comparable<Tarea> {
    private String descripcion;
    private int prioridad;
    private LocalDate fecha;

    public Tarea(String descripcion, int prioridad, LocalDate fecha) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String
    toString() {
        return "Tarea{" +
                "descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public int compareTo(Tarea o1) {
        return Integer.compare (o1.getPrioridad() ,this.prioridad);
    }
}
