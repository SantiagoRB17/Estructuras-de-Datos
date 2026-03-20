package co.edu.uniquindio.PreParciales.Preparcial1;
import java.util.*;

public class Punto10 {
    class Vehiculo{

        public void alquilar(){
            System.out.println("Vehiculo alquilado");
        }
    }
    class Auto extends Vehiculo{

        public void alquilar(){
            System.out.println("Auto alquilado");
        }
    }

    class Moto extends Vehiculo{

        public void alquilar(){
            System.out.println("Moto alquilada");
        }
    }

    class Camion extends Vehiculo{

        public void alquilar(){
            System.out.println("Camion alquilado");
        }
    }


    public static void alquilarVehiculos(List<? extends Vehiculo> lista){

        for(Vehiculo v : lista){
            v.alquilar();
        }
    }

}
