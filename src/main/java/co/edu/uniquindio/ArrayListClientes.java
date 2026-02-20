package co.edu.uniquindio;

import java.util.ArrayList;

import java.util.Comparator;

public class ArrayListClientes {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(13124,"Juan",""));
        clientes.add(new Cliente(63246,"Pedro",""));
        clientes.add(new Cliente(53654,"Maria",""));
        clientes.add(new Cliente(96987,"Ana",""));
        clientes.add(new Cliente(94368,"Jose",""));
        clientes.add(new Cliente(41234,"Santiago",""));
        System.out.println(clientes);

        Comparator<Cliente> porNombre = Comparator.comparing(Cliente::getNombre);

        System.out.println("-----------------------------------------------------------------");

        clientes.sort(porNombre);
        System.out.println(clientes);
    }


}
