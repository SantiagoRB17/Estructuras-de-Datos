public class DivideyVenceras{
    public static void main(String[] args){
        int [] lista = {1,2,3,8,4,5};
        System.out.println(encontrarMaximo(lista,0,lista.length-1));
    }
    public static int encontrarMaximo(int [] lista, int inicio, int fin){
        if (inicio == fin){
            return lista[inicio];
        }
        int mitad = (inicio + fin)/2;
        int list_izq = encontrarMaximo(lista, inicio, mitad);
        int list_der = encontrarMaximo(lista, mitad+1, fin);

        return Math.max(list_izq, list_der);
    }
}
