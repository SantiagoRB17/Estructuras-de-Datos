package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Punto4 {
    public static void main(String[] args) {
        Repositorio<Integer> repo = new Repositorio<>();
        repo.agregar(1);
        repo.agregar(2);
        repo.agregar(3);
        repo.agregar(4);
        System.out.println("Obtener elemento: ");
        System.out.println(repo.obtener(0));
        Iterator<Integer> it = repo.iterator();
        System.out.println("Iterador normal: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Iterador inverso: ");
        Iterator<Integer> it2 = repo.new IteradorInverso();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

    }

    static class Repositorio<T> implements Iterable<T> {
        private List<T> lista;
        public Repositorio() {
            this.lista = new ArrayList<>();
        }
        public void agregar(T elemento) {
            lista.add(elemento);
        }
        public T obtener(int indice) {
            if (indice < 0 || indice >= lista.size()) {
                throw new IndexOutOfBoundsException("Indice fuera de rango");
            }else{
                return lista.get(indice);
            }

        }
        @Override
        public Iterator<T> iterator() {
            return lista.iterator();
        }
        class IteradorInverso implements Iterator<T> {
            int indice = lista.size() - 1;
            @Override
            public boolean hasNext() {
                return indice >= 0;
            }
            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return lista.get(indice--);
            }
        }
    }
}
