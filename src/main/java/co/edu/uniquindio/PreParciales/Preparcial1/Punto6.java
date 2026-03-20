package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.*;

public class Punto6 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(maximo(lista));
    }

    public static <T extends Comparable<T>> T maximo(List<T> lista){

        if(lista.isEmpty()) return null;

        T max = lista.get(0);

        for(T e : lista){
            if(e.compareTo(max) > 0){
                max = e;
            }
        }

        return max;
    }
}
