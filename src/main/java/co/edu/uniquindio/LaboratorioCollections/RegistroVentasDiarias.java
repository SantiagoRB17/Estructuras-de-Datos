package co.edu.uniquindio.LaboratorioCollections;

import java.util.*;

public class RegistroVentasDiarias {
    public static void main(String[] args) {
        Venta venta1 = new Venta("12a3","Arroz",5,1000);
        Venta venta2 = new Venta("34b9","Papas",2,500);
        Venta venta3 = new Venta("67c8","Pollo",3,1500);
        // HashMap
        System.out.println("HashMap ------------------------------------------------------------------------------------");
        HashMap<String,Venta> ventasHashMap = new HashMap<>();
        registrarVentaHashMap(venta1,ventasHashMap);
        registrarVentaHashMap(venta2,ventasHashMap);
        registrarVentaHashMap(venta3,ventasHashMap);

        System.out.println("Ventas registradas:" + ventasHashMap.size());

        mostarInformacionProductoHashMap(venta1,ventasHashMap);
        mostarInformacionProductoHashMap(venta2,ventasHashMap);
        mostarInformacionProductoHashMap(venta3,ventasHashMap);

        mostrarVentasHashMap(venta1,ventasHashMap);

        //LinkedHashMap
        System.out.println("LinkedHashMap -----------------------------------------------------------------------------");
        LinkedHashMap<String,Venta> ventasLinkedHashMap = new LinkedHashMap<>();
        registrarVentaLinkedHashMap(venta3,ventasLinkedHashMap);
        registrarVentaLinkedHashMap(venta2,ventasLinkedHashMap);
        registrarVentaLinkedHashMap(venta1,ventasLinkedHashMap);
        System.out.println("Ventas registradas: " + ventasLinkedHashMap.size());

        mostarInformacionProductoLinkedHashMap(venta1,ventasLinkedHashMap);
        mostarInformacionProductoLinkedHashMap(venta2,ventasLinkedHashMap);
        mostarInformacionProductoLinkedHashMap(venta3,ventasLinkedHashMap);

        mostrarVentasLinkedHashMap(venta1,ventasLinkedHashMap);


        ordenarPorInsersionLinkedHashMap(ventasLinkedHashMap);

        //TreeMap
        System.out.println("TreeMap ------------------------------------------------------------------------------------");
        TreeMap<String,Venta> ventasTreeMap = new TreeMap<>();
        registrarVentaTreeMap(venta3,ventasTreeMap);
        registrarVentaTreeMap(venta2,ventasTreeMap);
        registrarVentaTreeMap(venta1,ventasTreeMap);
        System.out.println("Ventas registradas: " + ventasTreeMap.size());

        mostarInformacionProductoTreeMap(venta1,ventasTreeMap);
        mostarInformacionProductoTreeMap(venta2,ventasTreeMap);
        mostarInformacionProductoTreeMap(venta3,ventasTreeMap);

        mostrarVentasTreeMap(venta1,ventasTreeMap);

        ordenarPorCodigoProductoTreeMap(ventasTreeMap);
    }
    public static void registrarVentaHashMap(Venta venta, HashMap<String,Venta> ventas){
        ventas.put(venta.getCodigoProducto(),venta);
    }
    public static void registrarVentaLinkedHashMap(Venta venta, LinkedHashMap<String,Venta> ventasLinkedHashMap){
        ventasLinkedHashMap.put(venta.getCodigoProducto(),venta);
    }
    public static void registrarVentaTreeMap(Venta venta, TreeMap<String,Venta> ventasTreeMap){
        ventasTreeMap.put(venta.getCodigoProducto(),venta);
    }
    public static void mostarInformacionProductoHashMap(Venta venta, HashMap<String,Venta> ventas){
        System.out.println("Informacion Producto: " + ventas.get(venta.getCodigoProducto()));
    }
    public static void mostarInformacionProductoLinkedHashMap(Venta venta, LinkedHashMap<String,Venta> ventasLinkedHashMap){
        System.out.println("Informacion Producto: " + ventasLinkedHashMap.get(venta.getCodigoProducto()));
    }
    public static void mostarInformacionProductoTreeMap(Venta venta, TreeMap<String,Venta> ventasTreeMap){
        System.out.println("Informacion Producto: " + ventasTreeMap.get(venta.getCodigoProducto()));
    }
    public static void mostrarVentasHashMap(Venta venta, HashMap<String,Venta> ventas){
        for (Venta v : ventas.values()) {
            System.out.println("Venta: " + v);
        }
    }
    public static void mostrarVentasLinkedHashMap(Venta venta, LinkedHashMap<String,Venta> ventasLinkedHashMap){
        for (Venta v : ventasLinkedHashMap.values()) {
            System.out.println("Venta: "+v);
        }
    }
    public static void mostrarVentasTreeMap(Venta venta, TreeMap<String,Venta> ventasTreeMap){
        for (Venta v : ventasTreeMap.values()) {
            System.out.println("Venta: " + v);
        }
    }
    public static void ordenarPorCodigoProductoTreeMap(TreeMap<String,Venta> ventasTreeMap){
        System.out.println("Ordenamiento codigo del producto: " + ventasTreeMap);
    }

    public static void ordenarPorInsersionLinkedHashMap(LinkedHashMap<String,Venta> ventasLinkedHashMap){
        System.out.println("Ordenamiento por insersion:" + ventasLinkedHashMap);
    }

}
