package co.edu.uniquindio.TallerCollectionsGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Repositorio<T> implements Iterable<T>{
    List<T> lista;
    public Repositorio() {
        lista = new ArrayList<>();
    }
    public void agregar(T t) {
        lista.add(t);
    }
    public T obtener(int indice) {
        return lista.get(indice);
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }

    public Iterator<T> iteradorInverso(){
        return new IteradorInverso();
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
class MainRepositorio {
    public static void main(String[] args) {
        Repositorio<String> repositorio = new Repositorio<>();
        repositorio.agregar("Hola");
        repositorio.agregar("Mundo");
        Iterator it = repositorio.iterator();
        System.out.println("Iterador normal: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Iterator it2 = repositorio.iteradorInverso();
        System.out.println("Iterador inverso: ");
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

    }
}
