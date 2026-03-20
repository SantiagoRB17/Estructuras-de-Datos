package co.edu.uniquindio.PreParciales.Preparcial1;

public class Punto7 {

    public interface Comparador<T>{

        int comparar(T a, T b);
    }
    public class ComparadorGenerico<T extends Comparable<T>> implements Comparador<T>{

        @Override
        public int comparar(T a, T b) {
            return a.compareTo(b);
        }
    }
}
