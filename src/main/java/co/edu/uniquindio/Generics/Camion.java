package co.edu.uniquindio.Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Camion<T extends Carga> implements Iterable<T> {
    private ArrayList<T> listadeCarga;
    private String placa;
    public Camion(String placa) {
        this.listadeCarga= new ArrayList<>();
        this.placa = placa;
    }

    public void cargar(T objeto) {
        listadeCarga.add(objeto);
    }

    public T descargar(T objeto) throws Exception {
        if(listadeCarga.isEmpty()){
            throw new Exception("No hay carga");
        }

        T remove = listadeCarga.remove(listadeCarga.size() - 1);
        return remove;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorCamion();
    }

    class IteradorCamion implements Iterator<T> {
        private int indice=0;
        @Override
        public boolean hasNext() {
            return indice < listadeCarga.size();
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return listadeCarga.get(indice++);
        }
    }

    public T obtenerMasPesado(Comparator<T> comparador){
        if (listadeCarga.isEmpty()) {
            return null;
        }
        T max = listadeCarga.get(0);
        for (T elemento : listadeCarga) {
            if (comparador.compare(elemento, max) > 0) {
                max = elemento;
            }
        }
        return max;
    }
    public double obtenerPesoTotal(Camion<? extends Carga> camion){
        double pesoTotal = 0;
        for(Carga carga : camion.listadeCarga){
            pesoTotal += carga.obtenerPeso();
        }
        return pesoTotal;
    }
}
interface Carga {
    double obtenerPeso();
}

class Caja implements Carga {
    private double peso;
    private String nombre;
    public Caja(double peso, String nombre) {
        this.peso = peso;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "peso=" + peso +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public double obtenerPeso() {
        return peso;
    }
}

class Bulto implements Carga {
    private double peso;
    private String nombre;
    public Bulto(double peso, String nombre) {
        this.peso = peso;
        this.nombre = nombre;
    }

    @Override
    public double obtenerPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Bulto{" +
                "peso=" + peso +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

class ComparadorPeso implements Comparator<Carga> {

    @Override
    public int compare(Carga o1, Carga o2) {
        return Double.compare(o1.obtenerPeso(), o2.obtenerPeso());
    }
}

class main {
    public static void main(String[] args) {
        Camion<Carga> camion = new Camion<>("WJ123");
        camion.cargar(new Caja(5.5,"Peras"));
        camion.cargar(new Caja(10.5,"Manzanas"));
        camion.cargar(new Bulto(1.5,"Papa"));

        for(Carga s : camion){
            System.out.println();
            System.out.println(s);
        }
        System.out.println("Carga mas pesada del camion: " + camion.obtenerMasPesado(new ComparadorPeso()));
        System.out.println("Peso total de la carga del camion: " + camion.obtenerPesoTotal(camion));

    }
}