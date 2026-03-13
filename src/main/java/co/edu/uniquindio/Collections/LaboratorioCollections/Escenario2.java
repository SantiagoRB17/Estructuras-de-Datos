package co.edu.uniquindio.Collections.LaboratorioCollections;

import java.util.*;

public class Escenario2{

    public static void main(String[] args) {

        PlataformaVentas plataforma = new PlataformaVentas();

        Producto p1 = new Producto("COD001", "Laptop Lenovo",    2500000.0, "Electronica");
        Producto p2 = new Producto("COD002", "Mouse Logitech",     85000.0, "Electronica");
        Producto p3 = new Producto("COD003", "Camisa Polo",         65000.0, "Ropa");
        Producto p4 = new Producto("COD004", "Zapatillas Nike",    350000.0, "Ropa");
        Producto p5 = new Producto("COD005", "Escritorio Ikea",    780000.0, "Muebles");
        Producto p6 = new Producto("COD006", "Teclado Mecanico",   230000.0, "Electronica");

        plataforma.insertar(p1);
        plataforma.insertar(p2);
        plataforma.insertar(p3);
        plataforma.insertar(p4);
        plataforma.insertar(p5);
        plataforma.insertar(p6);

        // ── CASO 1: Orden de inserción preservado por LinkedHashMap ──
        System.out.println("=== CASO 1: Orden de inserción (LinkedHashMap) ===");
        // El primer elemento debe ser COD001 (primero insertado)
        String primero = plataforma.getPorCodigo().keySet().iterator().next();
        System.out.println("Primer insertado (debe ser COD001): " + primero);

        // ── CASO 2: Búsqueda por código existente ────────────────────
        System.out.println("\n=== CASO 2: Búsqueda por código existente ===");
        Producto encontrado = plataforma.buscarPorCodigo("COD003");
        System.out.println("Buscar COD003 (debe ser 'Camisa Polo'): "
                + (encontrado != null ? encontrado.getNombre() : "NULL"));

        // ── CASO 3: Búsqueda de código inexistente ───────────────────
        System.out.println("\n=== CASO 3: Búsqueda código inexistente ===");
        Producto noExiste = plataforma.buscarPorCodigo("COD999");
        System.out.println("Buscar COD999 (debe ser null): " + noExiste);

        // ── CASO 4: Mostrar ordenados por precio (TreeMap) ───────────
        System.out.println("\n=== CASO 4: Productos ordenados por precio (TreeMap) ===");
        // Esperado: Camisa(65k) < Mouse(85k) < Teclado(230k)
        //         < Zapatillas(350k) < Escritorio(780k) < Laptop(2.5M)
        plataforma.mostrarOrdenadosPorPrecio();

        // ── CASO 5: Filtrar por categoría existente ──────────────────
        System.out.println("\n=== CASO 5: Filtrar por categoría 'Electronica' ===");
        List<Producto> electronicos = plataforma.filtrarPorCategoria("Electronica");
        // Debe retornar: Laptop, Mouse, Teclado (3 productos)
        System.out.println("Cantidad esperada 3, obtenida: " + electronicos.size());
        electronicos.forEach(p -> System.out.println("  - " + p.getNombre()));

        // ── CASO 6: Filtrar por categoría inexistente ────────────────
        System.out.println("\n=== CASO 6: Filtrar categoría inexistente ===");
        List<Producto> vacios = plataforma.filtrarPorCategoria("Deportes");
        System.out.println("Categoria 'Deportes' (debe ser size=0): " + vacios.size());

        // ── CASO 7: Rendimiento con inserción masiva ─────────────────
        System.out.println("\n=== CASO 7: Rendimiento con inserción masiva ===");
        int[] tamanos = {100, 1000, 10000, 100000};

        for (int n : tamanos) {
            PlataformaVentas pv = new PlataformaVentas();
            Runtime rt = Runtime.getRuntime();
            rt.gc();
            long memAntes = rt.totalMemory() - rt.freeMemory();
            long inicio   = System.nanoTime();

            for (int i = 0; i < n; i++) {
                pv.insertar(new Producto(
                        "P" + i,
                        "Producto " + i,
                        (i + 1) * 100.0,
                        i % 2 == 0 ? "CatA" : "CatB"
                ));
            }

            long tiempoMs  = (System.nanoTime() - inicio) / 1_000_000;
            long memoriaKB = (rt.totalMemory() - rt.freeMemory() - memAntes) / 1024;

            inicio = System.nanoTime();
            pv.buscarPorCodigo("P" + (n / 2));
            long busquedaNs = System.nanoTime() - inicio;

            System.out.printf("n=%-7d | Inserción: %4dms | Búsqueda: %4dns | Memoria: %5dKB%n",
                    n, tiempoMs, busquedaNs, memoriaKB);
        }
    }
}
class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getCodigo()    { return codigo; }
    public String getNombre()    { return nombre; }
    public double getPrecio()    { return precio; }
    public String getCategoria() { return categoria; }
}

class PlataformaVentas {

    // Mantiene orden de inserción y acceso O(1) por código
    private LinkedHashMap<String, Producto> porCodigo = new LinkedHashMap<>();

    // Mantiene productos ordenados automáticamente por precio O(log n)
    private TreeMap<Double, List<Producto>> porPrecio = new TreeMap<>();

    // Agrupa por categoría usando LinkedHashMap para preservar orden de inserción
    private LinkedHashMap<String, List<Producto>> porCategoria = new LinkedHashMap<>();


    public void insertar(Producto p) {
        porCodigo.put(p.getCodigo(), p);
        porPrecio.computeIfAbsent(p.getPrecio(), k -> new ArrayList<>()).add(p);
        porCategoria.computeIfAbsent(p.getCategoria(), k -> new ArrayList<>()).add(p);
    }

    public Producto buscarPorCodigo(String codigo) {
        return porCodigo.getOrDefault(codigo, null);
    }

    public List<Producto> filtrarPorCategoria(String cat) {
        return porCategoria.getOrDefault(cat, Collections.emptyList());
    }

    public void mostrarOrdenadosPorPrecio() {
        porPrecio.forEach((precio, prods) ->
                prods.forEach(p ->
                        System.out.printf("$%.2f | %-25s | COD: %s%n",
                                precio, p.getNombre(), p.getCodigo())));
    }

    public LinkedHashMap<String, Producto> getPorCodigo() { return porCodigo; }
}