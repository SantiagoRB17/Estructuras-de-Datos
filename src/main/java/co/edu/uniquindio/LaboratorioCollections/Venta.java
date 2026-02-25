package co.edu.uniquindio.LaboratorioCollections;

public class Venta {
    private String CodigoProducto;
    private String NombreProducto;
    private int CantidadVendida;
    private double ValorTotalVenta;

    public Venta(String codigoProducto, String nombreProducto, int cantidadVendida, double valorTotalVenta) {
        CodigoProducto = codigoProducto;
        NombreProducto = nombreProducto;
        CantidadVendida = cantidadVendida;
        ValorTotalVenta = valorTotalVenta;
    }
    public String getCodigoProducto() {
        return CodigoProducto;
    }
    public String getNombreProducto() {
        return NombreProducto;
    }
    public int getCantidadVendida() {
        return CantidadVendida;
    }
    public double getValorTotalVenta() {
        return ValorTotalVenta;
    }
    @Override
    public String toString() {
        return "Venta{" + "CodigoProducto=" + CodigoProducto + ", NombreProducto=" + NombreProducto + ", CantidadVendida=" + CantidadVendida + ", ValorTotalVenta=" + ValorTotalVenta + '}';
    }
}
