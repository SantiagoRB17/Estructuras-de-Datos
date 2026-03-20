package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.*;

public class Punto5 {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        System.out.println(spliceStack(s,2,4));
    }

    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j){

        Stack<Integer> aux = new Stack<>();
        Stack<Integer> resultado = new Stack<>();

        int size = s.size();

        for(int k=0; k<size; k++){
            aux.push(s.pop());
        }

        int pos = 0;

        while(!aux.isEmpty()){

            int val = aux.pop();

            if(pos >= i && pos < j){
                resultado.push(val);
            }else{
                s.push(val);
            }

            pos++;
        }

        return resultado;
    }
}
