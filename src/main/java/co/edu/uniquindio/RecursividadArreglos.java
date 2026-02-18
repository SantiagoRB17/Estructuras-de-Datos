public class RecursividadArreglos {
    public static void main(String[] args){
        int [] arreglo = {1,2,3,4,5};
        imprimir(arreglo);
        sumarArreglo(arreglo);
        obtenerMayor(arreglo);
    }
    public static void imprimir(int[] arreglo){
        imprimir(arreglo,0);
    }
    public static void imprimir(int[] arreglo, int i){
        if (i == arreglo.length) {
            return;
        }
        System.out.println("Numero en la posicion " + i + ": "+arreglo[i]);
        imprimir(arreglo,i+1);
    }
    public static void sumarArreglo(int[] arreglo){
        sumarArreglo(arreglo,0,0);
    }
    public static void sumarArreglo(int[] arreglo, int i,int acc){
        if (i == arreglo.length) {
            System.out.println("La suma del arreglo es: " +acc);
            return;
        }
        sumarArreglo(arreglo,i+1,acc+arreglo[i]);
    }
    public static void obtenerMayor(int[] arreglo){
        obtenerMayor(arreglo,0,0);
    }
    public static void obtenerMayor(int[] arreglo, int i,int com){
        if(i == arreglo.length){
            System.out.println("El mayor es: " + com);
            return;
        }
        if (arreglo[i] > com){
            com = arreglo[i];
        }
        obtenerMayor(arreglo,i+1,com);
    }

}