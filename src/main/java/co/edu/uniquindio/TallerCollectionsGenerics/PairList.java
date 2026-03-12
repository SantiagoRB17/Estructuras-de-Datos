package co.edu.uniquindio.TallerCollectionsGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Node<K,V>{
    K key;
    V value;
    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
public class PairList<K,V>{
    private List<Node<K,V>> list;

    PairList(){
        this.list = new ArrayList<>();
    }
    public void add(K key, V value){
        list.add(new Node<>(key,value));
    }
    public void remove(K key){
        Iterator<Node<K,V>> it = list.iterator();
        while(it.hasNext()){
            Node<K,V> n = it.next();
            if(n.key.equals(key)){
                it.remove();
            }
        }
    }

    class IteratorNode implements Iterator<Node<K,V>>{
        int indice = 0;
        @Override
        public boolean hasNext() {
            return indice < list.size();
        }

        @Override
        public Node<K,V> next() {
            if(!hasNext()) throw new NoSuchElementException();
            return list.get(indice++);
        }
    }



    public Node<K,V> obtenerPar(K key){
        for(Node<K,V> n : list){
            if(n.key.equals(key)){
                return n;
            }
        }
        return null;
    }
}
class MainPairList {
    public static void main(String[] args) {
        PairList<String,Integer> ciudades = new PairList<String, Integer>();
        ciudades.add("Bogota",1);
        ciudades.add("Cali",2);
        ciudades.add("Medellin",3);
        System.out.println("Par obtenido: " + ciudades.obtenerPar("Bogota"));
        ciudades.remove("Medellin");
        Iterator it = ciudades.new IteratorNode();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
