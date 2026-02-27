package co.edu.uniquindio.LaboratorioCollections;

import java.util.Stack;

public class ParentesisBalanceados {
    public static void main(String[] args) {
        String expr1 = "(a+b)";
        if (estaBalanceada(expr1)) {
            System.out.println("Expresión válida");
        } else {
            System.out.println("Expresión inválida");
        }
    }

    public static boolean estaBalanceada(String expresion) {

        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es símbolo de apertura
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            }

            // Si es símbolo de cierre
            else if (c == ')' || c == '}' || c == ']') {

                if (pila.isEmpty()) {
                    return false;
                }

                char ultimo = pila.pop();

                if ((c == ')' && ultimo != '(') ||
                        (c == '}' && ultimo != '{') ||
                        (c == ']' && ultimo != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }
}
