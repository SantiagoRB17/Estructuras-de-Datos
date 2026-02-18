package co.edu.uniquindio;

public class BusquedaBinaria {
    public static void main(String[] args) {
        int [] lista = {1,2,3,4,5};
        System.out.println(buscar(lista,2,0,lista.length-1));

    }
    public static int buscar(int [] lista, int valor,int inicio, int fin){
        int mitad = (inicio + fin)/2;
        if (lista[mitad] == valor){
            return mitad;
        }else if (lista[mitad] > valor){
            return buscar(lista,valor,inicio,mitad-1);
        }else{
            return buscar(lista,valor,mitad+1,fin);
        }
    }
}