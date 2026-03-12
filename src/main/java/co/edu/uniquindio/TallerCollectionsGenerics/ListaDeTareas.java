package co.edu.uniquindio.TallerCollectionsGenerics;

import java.time.LocalDate;
import java.util.*;

public class ListaDeTareas implements Iterable<Tarea>{
    private PriorityQueue<Tarea> listaDeTareas = new PriorityQueue<>();
    private ArrayList<Tarea> listaDeTareas2 = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        listaDeTareas.add(tarea);
    }
    public void agregarTarea2(Tarea tarea) {
        listaDeTareas2.add(tarea);
    }
    public void ordenarPorFecha() {
        Comparator<Tarea> fecha = (t1, t2) -> t1.getFecha().compareTo(t2.getFecha());
        listaDeTareas2.sort(fecha);
    }

    public void imprimirTareasPorPrioridad() {
        System.out.println("Tareas ordenadas por prioridad: ");
        for (Tarea tarea : listaDeTareas) {
            System.out.println(tarea);
        }
    }

    public void imprimirTareasPorFecha() {
        System.out.println("Tareas ordenadas por fecha: ");
        for (Tarea tarea : listaDeTareas2) {
            System.out.println(tarea);
        }
    }

    @Override
    public Iterator<Tarea> iterator() {
        return listaDeTareas.iterator();
    }
}
class Main {
    public static void main(String[] args) {
        ListaDeTareas listaDeTareas = new ListaDeTareas();
        Tarea tarea = new Tarea("Cita medica", 2, LocalDate.of(2026,03,06));
        Tarea tarea2 = new Tarea("Cita dientes", 5, LocalDate.of(2025,03,06));
        Tarea tarea3 = new Tarea("Mecanico", 3, LocalDate.of(2023,02,06));
        Tarea tarea4 = new Tarea("Compra", 1, LocalDate.of(2027, 07,10));
        listaDeTareas.agregarTarea(tarea);
        listaDeTareas.agregarTarea(tarea2);
        listaDeTareas.agregarTarea(tarea3);
        listaDeTareas.agregarTarea(tarea4);
        listaDeTareas.agregarTarea2(tarea);
        listaDeTareas.agregarTarea2(tarea2);
        listaDeTareas.agregarTarea2(tarea3);
        listaDeTareas.agregarTarea2(tarea4);

        listaDeTareas.imprimirTareasPorPrioridad();
        listaDeTareas.ordenarPorFecha();
        listaDeTareas.imprimirTareasPorFecha();

    }
}
