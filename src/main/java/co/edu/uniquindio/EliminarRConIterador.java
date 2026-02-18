package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Iterator;

public class EliminarRConIterador {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Santiago");
        lista.add("Maria");
        lista.add("Raul");
        lista.add("Laura");
        lista.add("Renteria");
        eliminarR(lista);
        System.out.println(lista);
    }
    public static void eliminarR(ArrayList<String> lista){
        Iterator<String> it = lista.iterator();

        while(it.hasNext()){
            String nombre = it.next();
            if(nombre.startsWith("R")){
                it.remove();
            }
        }
    }

}