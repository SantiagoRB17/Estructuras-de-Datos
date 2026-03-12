package co.edu.uniquindio.Collections.LaboratorioCollections;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Escenario1 {
    public static void medir(int n) {
            RegistroPacientes sistema = new RegistroPacientes();
            long inicio = System.nanoTime();
            for (int i = 0; i < n; i++) {
                sistema.registrar(new Paciente("DOC" + i, "Paciente" + i, (i % 3) + 1));
            }
            long insercion = System.nanoTime() - inicio;
            inicio = System.nanoTime();
            sistema.buscar("DOC" + (n / 2));
            long busqueda = System.nanoTime() - inicio;
            Runtime rt = Runtime.getRuntime();
            rt.gc();
            long memoriaKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
            System.out.printf("n=%d | Inserción: %dms | Búsqueda: %dns | Memoria: %dKB%n",
                    n, insercion / 1_000_000, busqueda, memoriaKB);
        }

        public static void main (String[]args){
            medir(100);
            medir(1000);
            medir(10000);
            medir(100000);
        }

    }

    class RegistroPacientes {
        private LinkedHashMap<String, Paciente> registros = new LinkedHashMap<>();
        private PriorityQueue<Paciente> colaUrgencias = new PriorityQueue<>();

        public void registrar(Paciente p) {
            if (registros.containsKey(p.getDocumento())) {
                System.out.println("Paciente ya registrado: " + p.getDocumento());
                return;
            }
            registros.put(p.getDocumento(), p);
            colaUrgencias.add(p);
        }

        public Paciente buscar(String documento) {
            return registros.getOrDefault(documento, null);
        }

        public Paciente atenderSiguiente() {
            return colaUrgencias.poll(); // saca el más grave
        }

        public void mostrarEnOrdenLlegada() {
            registros.values().forEach(p ->
                    System.out.println(p.getDocumento() + " - " + p.getNombre()));
        }
    }

    class Paciente implements Comparable<Paciente> {
        private String documento;
        private String nombre;
        private int gravedad;

        public Paciente(String documento, String nombre, int gravedad) {
            this.documento = documento;
            this.nombre = nombre;
            this.gravedad = gravedad;
        }

        @Override
        public int compareTo(Paciente otro) {
            return Integer.compare(otro.gravedad, this.gravedad); // mayor gravedad primero
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getGravedad() {
            return gravedad;
        }

        public void setGravedad(int gravedad) {
            this.gravedad = gravedad;
        }
    }


