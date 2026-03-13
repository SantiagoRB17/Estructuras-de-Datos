package co.edu.uniquindio.PreParciales.Preparcial1;

import java.util.*;

public class Punto8 {

    static class Pair<A,B>{
        public A first;
        public B second;

        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }

    public static Pair<Stack<Integer>,Stack<Integer>> splitStack(Stack<Integer> s, int i){

        Stack<Integer> inverso = new Stack<>();
        Stack<Integer> subPila = new Stack<>();

        while(!s.isEmpty()){
            inverso.push(s.pop());
        }

        int pos = 0;

        while(!inverso.isEmpty()){

            int val = inverso.pop();

            if(pos < i){
                subPila.push(val);
            }else{
                s.push(val);
            }

            pos++;
        }

        return new Pair<>(subPila,s);
    }
}
