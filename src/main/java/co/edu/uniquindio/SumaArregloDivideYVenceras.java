public class SumaArregloDivideYVenceras {
    public static void main(String[] args) {
        int [] lista = {1,2,5,4};
        System.out.println(sumarArreglo(lista,0, lista.length-1));
    }

    public static int sumarArreglo(int[] arreglo, int inicio, int fin){
        if (inicio == fin){
            return arreglo[inicio];
        }
        int mitad = (inicio + fin)/2;
        int izq = sumarArreglo(arreglo,inicio,mitad);
        int der = sumarArreglo(arreglo,mitad+1,fin);
        return izq + der;
    }
}