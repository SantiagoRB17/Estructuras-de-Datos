package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.*;

public class Punto11 {
    public static void main(String[] args) {
        Queue<Integer> cola1 = new LinkedList<>();
        Queue<Integer> cola2 = new LinkedList<>();

        cola1.add(1);
        cola1.add(3);
        cola1.add(5);

        cola2.add(2);
        cola2.add(4);
        cola2.add(6);

        Queue<Integer> resultado = mergeQueues(cola1, cola2);

        System.out.println(resultado);
    }

    public static <T> Queue<T> mergeQueues(Queue<T> q1, Queue<T> q2){

        Queue<T> resultado = new LinkedList<>();

        while(!q1.isEmpty() || !q2.isEmpty()){

            if(!q1.isEmpty()){
                resultado.add(q1.poll());
            }

            if(!q2.isEmpty()){
                resultado.add(q2.poll());
            }
        }

        return resultado;
    }


}
