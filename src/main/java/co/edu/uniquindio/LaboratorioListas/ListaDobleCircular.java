package co.edu.uniquindio.LaboratorioListas;

public class ListaDobleCircular<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;

    public ListaDobleCircular() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    public void agregarFinal(T valorNodo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
            nuevoNodo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnteriorNodo(nuevoNodo);
        } else {
            nuevoNodo.setAnteriorNodo(nodoUltimo);
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoPrimero.setAnteriorNodo(nuevoNodo);
            nodoUltimo = nuevoNodo;
        }
        tamanio++;
    }

    public void agregarInicio(T valorNodo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
            nuevoNodo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnteriorNodo(nuevoNodo);
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nuevoNodo.setAnteriorNodo(nodoUltimo);
            nodoPrimero.setAnteriorNodo(nuevoNodo);
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    public T obtenerValorNodo(int indice) {
        if (!indiceValido(indice)) {
            throw new RuntimeException("Índice no válido");
        }

        NodoDoble<T> actual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguienteNodo();
        }
        return actual.getValorNodo();
    }

    public int buscar(T valor) {
        if (estaVacia()) {
            return -1;
        }

        NodoDoble<T> actual = nodoPrimero;
        for (int i = 0; i < tamanio; i++) {
            if (actual.getValorNodo().equals(valor)) {
                return i;
            }
            actual = actual.getSiguienteNodo();
        }
        return -1;
    }

    public T eliminar(T dato) {
        if (estaVacia()) {
            throw new RuntimeException("Lista vacía");
        }

        NodoDoble<T> actual = nodoPrimero;

        for (int i = 0; i < tamanio; i++) {
            if (actual.getValorNodo().equals(dato)) {
                if (tamanio == 1) {
                    nodoPrimero = null;
                    nodoUltimo = null;
                } else {
                    actual.getAnteriorNodo().setSiguienteNodo(actual.getSiguienteNodo());
                    actual.getSiguienteNodo().setAnteriorNodo(actual.getAnteriorNodo());

                    if (actual == nodoPrimero) {
                        nodoPrimero = actual.getSiguienteNodo();
                    }
                    if (actual == nodoUltimo) {
                        nodoUltimo = actual.getAnteriorNodo();
                    }
                }
                tamanio--;
                return dato;
            }
            actual = actual.getSiguienteNodo();
        }

        throw new RuntimeException("El elemento no existe");
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> actual = nodoPrimero;
        for (int i = 0; i < tamanio; i++) {
            System.out.print(actual.getValorNodo() + "\t");
            actual = actual.getSiguienteNodo();
        }
        System.out.println();
    }

    public void imprimirListaReversa() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> actual = nodoUltimo;
        for (int i = 0; i < tamanio; i++) {
            System.out.print(actual.getValorNodo() + "\t");
            actual = actual.getAnteriorNodo();
        }
        System.out.println();
    }

    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamanio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public NodoDoble<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public NodoDoble<T> getNodoUltimo() {
        return nodoUltimo;
    }
}
