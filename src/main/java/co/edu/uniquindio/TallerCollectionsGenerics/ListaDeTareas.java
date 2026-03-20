package co.edu.uniquindio.TallerCollectionsGenerics;

import java.time.LocalDate;
import java.util.*;

public class ListaDeTareas implements Iterable<Tarea>{
    private List<Tarea> listaDeTareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        listaDeTareas.add(tarea);
    }
    public void ordenarPorFecha(){
        Comparator<Tarea> porFecha= Comparator.comparing(Tarea::getFecha);
        listaDeTareas.sort(porFecha);
    }
    public void ordenarPorPrioridad(){
        Comparator<Tarea> prioridad= Comparator.comparing(Tarea::getPrioridad);
        listaDeTareas.sort(prioridad);
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


        listaDeTareas.ordenarPorPrioridad();
        for (Tarea t : listaDeTareas) {
            System.out.println(t);
        }
        listaDeTareas.ordenarPorFecha();
        for (Tarea t : listaDeTareas) {
            System.out.println(t);
        }


    }
}
