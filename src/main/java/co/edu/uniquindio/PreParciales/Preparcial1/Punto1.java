package co.edu.uniquindio.PreParciales.Preparcial1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Punto1 {
    public static void main(String[] args) {
        Tarea tarea = new Tarea("Cita medica", 2, LocalDate.of(2026,03,06));
        Tarea tarea2 = new Tarea("Cita dientes", 5, LocalDate.of(2025,03,06));
        Tarea tarea3 = new Tarea("Mecanico", 3, LocalDate.of(2023,02,06));
        Tarea tarea4 = new Tarea("Compra", 1, LocalDate.of(2027, 07,10));
        ListaDeTareas listaDeTareas = new ListaDeTareas();
        listaDeTareas.agregar(tarea);
        listaDeTareas.agregar(tarea2);
        listaDeTareas.agregar(tarea3);
        listaDeTareas.agregar(tarea4);
        listaDeTareas.ordenarPorFecha();
        System.out.println("Ordenado por fecha:");
        listaDeTareas.mostrar();
        listaDeTareas.ordenarPorPrioridad();
        System.out.println("Ordenado por prioridad:");
        listaDeTareas.mostrar();


    }

   static class ListaDeTareas{
       private List<Tarea> listaDeTareas;

       public ListaDeTareas() {
           this.listaDeTareas = new ArrayList<>();
       }

       public void agregar(Tarea tarea){
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
       public void mostrar(){
           for (Tarea t : listaDeTareas) {
               System.out.println(t);
           }
       }

   }
   static class Tarea<T>{
       private String descripcion;
       private int prioridad;
       private LocalDate fecha;

       public Tarea(String descripcion, int prioridad,LocalDate fecha) {
           this.fecha = fecha;
           this.prioridad = prioridad;
           this.descripcion = descripcion;
       }

       public LocalDate getFecha() {
           return fecha;
       }

       public int getPrioridad() {
           return prioridad;
       }

       @Override
       public String toString() {
           return "Tarea{" +
                   "descripcion='" + descripcion + '\'' +
                   ", prioridad=" + prioridad +
                   ", fecha=" + fecha +
                   '}';
       }
   }
}
