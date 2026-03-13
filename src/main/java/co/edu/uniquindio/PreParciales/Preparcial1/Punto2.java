package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Punto2 {
    public static void main(String[] args) {
        PairList<String,Integer> lista = new PairList<>();
        lista.agregar("a",1);
        lista.agregar("b",2);
        lista.agregar("c",3);
        lista.agregar("d",4);
        lista.mostrar();
        System.out.println("Eliminar par: ");
        lista.eliminar("a");
        lista.mostrar();
        System.out.println("Obtener par: ");
        System.out.println(lista.obtenerPar("b").getValor());


    }

    static class Pair<K,V>{
        private K clave;
        private V valor;
        public Pair(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K getClave() {
            return clave;
        }

        public V getValor() {
            return valor;
        }
    }
    static class PairList<K,V>{
        private List<Pair<K,V>> pairList;

        public PairList() {
            this.pairList = new ArrayList<>();
        }
        public void agregar(K clave, V valor){
            pairList.add(new Pair<K,V>(clave,valor));
        }
        public void eliminar(K clave){
            Iterator<Pair<K,V>> it = pairList.iterator();

            while (it.hasNext()) {
                Pair<K,V> p = it.next();
                if(p.getClave().equals(clave)){
                    pairList.remove(p);
                    return;
                }
            }
            throw new IllegalArgumentException("No se encontro la clave");
        }
        public Pair<K,V> obtenerPar(K clave){
            for(Pair<K,V> p : pairList){
                if(p.getClave().equals(clave)){
                    return p;
                }
            }
            return null;
        }
        public void mostrar(){
            for(Pair<K,V> p : pairList){
                System.out.println(p.getClave() + " " + p.getValor());
            }
        }

    }
}
