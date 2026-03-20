package co.edu.uniquindio.TallerCollectionsGenerics;

import java.time.LocalDate;
import java.util.NoSuchElementException;

public class Tarea<T>{
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
}
