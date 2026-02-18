package co.edu.uniquindio;

public class Matrushka {
    public static void mat(int n){
        if(n==0){
            return;
        }
        System.out.println("Abriendo muñeca " + n);
        mat(n-1);
        System.out.println("Cerrando muñeca " + n);
    }
    public static void main(String[] args){
        mat(5);
    }
}
