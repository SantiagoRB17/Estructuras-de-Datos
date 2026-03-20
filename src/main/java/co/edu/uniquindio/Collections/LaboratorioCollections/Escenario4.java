package co.edu.uniquindio.Collections.LaboratorioCollections;

import java.util.*;

class Escenario4{

    public static void main(String[] args) {

        CatalogoEcommerce catalogo = new CatalogoEcommerce();

        ProductoCatalogo pc1 = new ProductoCatalogo("COD001", "Laptop Lenovo",       2500000.0);
        ProductoCatalogo pc2 = new ProductoCatalogo("COD002", "Mouse Logitech",        85000.0);
        ProductoCatalogo pc3 = new ProductoCatalogo("COD003", "Teclado Mecanico",     230000.0);
        ProductoCatalogo pc4 = new ProductoCatalogo("COD004", "Monitor Samsung",      950000.0);
        ProductoCatalogo pc5 = new ProductoCatalogo("COD005", "Auriculares Sony",     310000.0);
        ProductoCatalogo pc6 = new ProductoCatalogo("COD006", "Webcam Logitech",      175000.0);

        // ── CASO 1: Inserción de productos ───────────────────
        System.out.println("=== CASO 1: Insercion de productos ===");
        catalogo.insertar(pc1);
        catalogo.insertar(pc2);
        catalogo.insertar(pc3);
        catalogo.insertar(pc4);
        catalogo.insertar(pc5);
        catalogo.insertar(pc6);
        System.out.println("Total productos (debe ser 6): "
                + catalogo.getTotalProductos());

        // ── CASO 2: Inserción de código duplicado ─────────────
        System.out.println("\n=== CASO 2: Codigo duplicado ===");
        catalogo.insertar(new ProductoCatalogo("COD001", "Producto Falso", 1.0));
        System.out.println("Total productos (debe seguir siendo 6): "
                + catalogo.getTotalProductos());

        // ── CASO 3: Búsqueda por código existente ─────────────
        System.out.println("\n=== CASO 3: Busqueda por codigo existente ===");
        ProductoCatalogo encontrado = catalogo.buscarPorCodigo("COD004");
        System.out.println("Buscar COD004 (debe ser 'Monitor Samsung'): "
                + (encontrado != null ? encontrado.getNombre() : "NULL"));

        // ── CASO 4: Búsqueda por código inexistente ───────────
        System.out.println("\n=== CASO 4: Busqueda codigo inexistente ===");
        ProductoCatalogo noExiste = catalogo.buscarPorCodigo("COD999");
        System.out.println("Buscar COD999 (debe ser null): " + noExiste);

        // ── CASO 5: Mostrar ordenados por precio (TreeMap) ────
        System.out.println("\n=== CASO 5: Productos ordenados por precio ===");
        // Esperado: Mouse(85k) < Webcam(175k) < Teclado(230k)
        //         < Auriculares(310k) < Monitor(950k) < Laptop(2.5M)
        catalogo.mostrarOrdenadosPorPrecio();

        // ── CASO 6: Eliminar producto existente ───────────────
        System.out.println("\n=== CASO 6: Eliminar COD003 ===");
        catalogo.eliminar("COD003");
        System.out.println("Total productos (debe ser 5): "
                + catalogo.getTotalProductos());
        System.out.println("Buscar COD003 tras eliminar (debe ser null): "
                + catalogo.buscarPorCodigo("COD003"));

        // ── CASO 7: Verificar TreeMap tras eliminación ────────
        System.out.println("\n=== CASO 7: Catalogo tras eliminar COD003 ===");
        // Teclado Mecanico no debe aparecer
        catalogo.mostrarOrdenadosPorPrecio();

        // ── CASO 8: Eliminar producto inexistente ─────────────
        System.out.println("\n=== CASO 8: Eliminar codigo inexistente ===");
        catalogo.eliminar("COD999");

        // ── CASO 9: Orden de inserción preservado (LinkedHashMap)
        System.out.println("\n=== CASO 9: Orden de insercion (LinkedHashMap) ===");
        // Debe aparecer COD001 primero y COD006 último (ignorando COD003 eliminado)
        System.out.println("--- Orden de insercion ---");
        catalogo.getPorCodigo().forEach((cod, p) ->
                System.out.println("  " + cod + " | " + p.getNombre()));

        // ── CASO 10: Rendimiento con carga masiva ─────────────
        System.out.println("\n=== CASO 10: Rendimiento con carga masiva ===");
        System.out.printf("%-10s | %-15s | %-18s | %-16s | %-12s%n",
                "n", "Insercion", "Busqueda", "Eliminacion", "Memoria");
        System.out.println("-".repeat(80));

        int[] tamanos = {100, 1000, 10000, 100000};

        for (int n : tamanos) {
            CatalogoEcommerce cat = new CatalogoEcommerce();
            cat.setVerbose(false);

            Runtime rt = Runtime.getRuntime();
            rt.gc();
            long memAntes = rt.totalMemory() - rt.freeMemory();
            long inicio   = System.nanoTime();

            for (int i = 0; i < n; i++) {
                cat.insertar(new ProductoCatalogo(
                        "P" + i, "Producto " + i, (i + 1) * 100.0));
            }

            long tiempoMs  = (System.nanoTime() - inicio) / 1_000_000;
            long memoriaKB = (rt.totalMemory() - rt.freeMemory() - memAntes) / 1024;

            inicio = System.nanoTime();
            cat.buscarPorCodigo("P" + (n / 2));
            long busquedaNs = System.nanoTime() - inicio;

            inicio = System.nanoTime();
            cat.eliminar("P" + (n / 2));
            long eliminaNs = System.nanoTime() - inicio;

            System.out.printf(
                    "n=%-7d | Insercion: %4dms | Busqueda: %6dns | Eliminar: %6dns | Memoria: %5dKB%n",
                    n, tiempoMs, busquedaNs, eliminaNs, memoriaKB);
        }
    }
}

class ProductoCatalogo {
    private String codigo;
    private String nombre;
    private double precio;

    public ProductoCatalogo(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}


class CatalogoEcommerce {

    // Acceso O(1) por código, preserva orden de inserción
    private LinkedHashMap<String, ProductoCatalogo> porCodigo = new LinkedHashMap<>();

    // Orden automático por precio O(log n)
    private TreeMap<Double, List<ProductoCatalogo>> porPrecio = new TreeMap<>();

    private boolean verbose = true;

    public void setVerbose(boolean verbose) { this.verbose = verbose; }

    private void log(String mensaje) {
        if (verbose) System.out.println(mensaje);
    }

    public void insertar(ProductoCatalogo p) {
        if (porCodigo.containsKey(p.getCodigo())) {
            log("Ya existe un producto con codigo: " + p.getCodigo());
            return;
        }
        porCodigo.put(p.getCodigo(), p);
        porPrecio.computeIfAbsent(p.getPrecio(), k -> new ArrayList<>()).add(p);
        log("Producto insertado: [" + p.getCodigo() + "] "
                + p.getNombre() + " | $" + String.format("%.2f", p.getPrecio()));
    }

    public ProductoCatalogo buscarPorCodigo(String codigo) {
        return porCodigo.getOrDefault(codigo, null);
    }

    public void eliminar(String codigo) {
        ProductoCatalogo p = porCodigo.remove(codigo);
        if (p != null) {
            List<ProductoCatalogo> lista = porPrecio.get(p.getPrecio());
            if (lista != null) {
                lista.remove(p);
                if (lista.isEmpty()) porPrecio.remove(p.getPrecio());
            }
            log("Producto eliminado: [" + codigo + "] " + p.getNombre());
        } else {
            log("No se encontro el producto: [" + codigo + "]");
        }
    }

    public void mostrarOrdenadosPorPrecio() {
        if (porPrecio.isEmpty()) {
            System.out.println("El catalogo esta vacio.");
            return;
        }
        System.out.println("--- Catalogo ordenado por precio ---");
        porPrecio.forEach((precio, productos) ->
                productos.forEach(p ->
                        System.out.printf("  $%10.2f | %-25s | COD: %s%n",
                                precio, p.getNombre(), p.getCodigo())));
    }

    public int getTotalProductos()                                      { return porCodigo.size(); }
    public LinkedHashMap<String, ProductoCatalogo> getPorCodigo()       { return porCodigo; }
    public TreeMap<Double, List<ProductoCatalogo>> getPorPrecio()       { return porPrecio; }
}


