package co.edu.uniquindio.Collections.LaboratorioCollections;


import java.util.LinkedHashMap;
import java.util.Map;

class Escenario3 {

    public static void main(String[] args) {

        SistemaTaxis sistema = new SistemaTaxis();

        Solicitud s1 = new Solicitud("SOL001", "Carlos",  "Calle 10",   "Aeropuerto");
        Solicitud s2 = new Solicitud("SOL002", "Maria",   "Carrera 5",  "Centro Comercial");
        Solicitud s3 = new Solicitud("SOL003", "Pedro",   "Avenida 30", "Universidad");
        Solicitud s4 = new Solicitud("SOL004", "Laura",   "Calle 45",   "Hospital");
        Solicitud s5 = new Solicitud("SOL005", "Andres",  "Carrera 15", "Estadio");

        // ── CASO 1: Registro de solicitudes ──────────────────
        System.out.println("=== CASO 1: Registro de solicitudes ===");
        sistema.registrar(s1);
        sistema.registrar(s2);
        sistema.registrar(s3);
        sistema.registrar(s4);
        sistema.registrar(s5);
        System.out.println("Total pendientes (debe ser 5): "
                + sistema.getTotalPendientes());

        // ── CASO 2: Registro de ID duplicado ─────────────────
        System.out.println("\n=== CASO 2: ID duplicado ===");
        sistema.registrar(new Solicitud("SOL001", "Intruso", "X", "Y"));
        System.out.println("Total pendientes (debe seguir siendo 5): "
                + sistema.getTotalPendientes());

        // ── CASO 3: Mostrar pendientes en orden FIFO ─────────
        System.out.println("\n=== CASO 3: Mostrar pendientes (orden FIFO) ===");
        sistema.mostrarPendientes();

        // ── CASO 4: Atender la solicitud más antigua ─────────
        System.out.println("\n=== CASO 4: Atender siguiente (debe ser SOL001) ===");
        Solicitud atendida = sistema.atenderSiguiente();
        System.out.println("Atendida correctamente: "
                + (atendida != null && atendida.getId().equals("SOL001")));
        System.out.println("Total pendientes (debe ser 4): "
                + sistema.getTotalPendientes());

        // ── CASO 5: Cancelar solicitud existente ─────────────
        System.out.println("\n=== CASO 5: Cancelar SOL003 ===");
        boolean cancelada = sistema.cancelar("SOL003");
        System.out.println("Cancelacion exitosa (debe ser true): " + cancelada);
        System.out.println("Total pendientes (debe ser 3): "
                + sistema.getTotalPendientes());

        // ── CASO 6: Cancelar solicitud inexistente ────────────
        System.out.println("\n=== CASO 6: Cancelar ID inexistente ===");
        boolean noExiste = sistema.cancelar("SOL999");
        System.out.println("Cancelacion (debe ser false): " + noExiste);

        // ── CASO 7: Verificar orden FIFO tras cancelación ─────
        System.out.println("\n=== CASO 7: Pendientes tras cancelar SOL003 ===");
        sistema.mostrarPendientes();

        // ── CASO 8: Vaciar la cola completa ──────────────────
        System.out.println("\n=== CASO 8: Vaciar cola completa ===");
        while (sistema.getTotalPendientes() > 0) {
            sistema.atenderSiguiente();
        }
        sistema.atenderSiguiente(); // intento en cola vacía

        // ── CASO 9: Rendimiento con carga masiva ──────────────
        System.out.println("\n=== CASO 9: Rendimiento con carga masiva ===");
        System.out.printf("%-10s | %-15s | %-18s | %-16s | %-12s%n",
                "n", "Registro", "Cancelar", "Atender", "Memoria");
        System.out.println("-".repeat(80));

        int[] tamanos = {100, 1000, 10000, 100000};

        for (int n : tamanos) {
            SistemaTaxis st = new SistemaTaxis();
            st.setVerbose(false); // silencia prints durante prueba masiva

            Runtime rt = Runtime.getRuntime();
            rt.gc();
            long memAntes = rt.totalMemory() - rt.freeMemory();
            long inicio   = System.nanoTime();

            for (int i = 0; i < n; i++) {
                st.registrar(new Solicitud(
                        "ID" + i, "Usuario" + i, "Origen" + i, "Destino" + i));
            }

            long tiempoMs  = (System.nanoTime() - inicio) / 1_000_000;
            long memoriaKB = (rt.totalMemory() - rt.freeMemory() - memAntes) / 1024;

            inicio = System.nanoTime();
            st.cancelar("ID" + (n / 2));
            long cancelNs = System.nanoTime() - inicio;

            inicio = System.nanoTime();
            st.atenderSiguiente();
            long atenderNs = System.nanoTime() - inicio;

            System.out.printf("n=%-7d | Registro: %4dms | Cancelar: %6dns | Atender: %6dns | Memoria: %5dKB%n",
                    n, tiempoMs, cancelNs, atenderNs, memoriaKB);
        }
    }
}

class Solicitud {
    private String id;
    private String usuario;
    private String origen;
    private String destino;

    public Solicitud(String id, String usuario, String origen, String destino) {
        this.id        = id;
        this.usuario   = usuario;
        this.origen    = origen;
        this.destino   = destino;
    }

    public String getId()      { return id; }
    public String getUsuario() { return usuario; }
    public String getOrigen()  { return origen; }
    public String getDestino() { return destino; }
}


class SistemaTaxis {

    private LinkedHashMap<String, Solicitud> pendientes = new LinkedHashMap<>();
    private boolean verbose = true; // controla si imprime o no

    public void setVerbose(boolean verbose) { this.verbose = verbose; }

    private void log(String mensaje) {
        if (verbose) System.out.println(mensaje);
    }

    public void registrar(Solicitud s) {
        if (pendientes.containsKey(s.getId())) {
            log("Ya existe una solicitud con ID: " + s.getId());
            return;
        }
        pendientes.put(s.getId(), s);
        log("Solicitud registrada: [" + s.getId() + "] "
                + s.getUsuario() + " | " + s.getOrigen() + " -> " + s.getDestino());
    }

    public Solicitud atenderSiguiente() {
        if (pendientes.isEmpty()) {
            log("No hay solicitudes pendientes.");
            return null;
        }
        Map.Entry<String, Solicitud> primera =
                pendientes.entrySet().iterator().next();
        pendientes.remove(primera.getKey());
        log("Atendiendo: [" + primera.getValue().getId() + "] "
                + primera.getValue().getUsuario());
        return primera.getValue();
    }

    public boolean cancelar(String id) {
        if (pendientes.remove(id) != null) {
            log("Solicitud cancelada: [" + id + "]");
            return true;
        }
        log("No se encontró la solicitud: [" + id + "]");
        return false;
    }

    public void mostrarPendientes() {
        if (pendientes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }
        System.out.println("--- Solicitudes pendientes (" + pendientes.size() + ") ---");
        pendientes.forEach((id, s) ->
                System.out.printf("  [%s] %-15s | %s -> %s%n",
                        id, s.getUsuario(), s.getOrigen(), s.getDestino()));
    }

    public int getTotalPendientes()                        { return pendientes.size(); }
    public LinkedHashMap<String, Solicitud> getPendientes(){ return pendientes; }
}


