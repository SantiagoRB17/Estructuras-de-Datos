package co.edu.uniquindio.LaboratorioListas;

/**
 * Lista simplemente enlazada genérica.
 * Usada en el Escenario 1 (Panadería) como cola FIFO.
 */
public class ListaSimple<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;

    public ListaSimple() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    public void agregarInicio(T valorNodo) {
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    public void agregarfinal(T valorNodo) {
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoUltimo = nuevoNodo;
        }
        tamanio++;
    }

    public T obtenerValorNodo(int indice) {
        if (!indiceValido(indice)) return null;
        Nodo<T> actual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguienteNodo();
        }
        return actual.getValorNodo();
    }

    public T eliminarPrimero() {
        if (estaVacia()) throw new RuntimeException("Lista vacía");
        T valor = nodoPrimero.getValorNodo();
        nodoPrimero = nodoPrimero.getSiguienteNodo();
        if (nodoPrimero == null) nodoUltimo = null;
        tamanio--;
        return valor;
    }

    public T eliminar(T dato) {
        if (estaVacia()) throw new RuntimeException("Lista vacía");
        Nodo<T> actual = nodoPrimero;
        Nodo<T> previo = null;
        while (actual != null) {
            if (actual.getValorNodo().equals(dato)) {
                if (previo == null) {
                    nodoPrimero = actual.getSiguienteNodo();
                } else {
                    previo.setSiguienteNodo(actual.getSiguienteNodo());
                }
                if (actual.getSiguienteNodo() == null) {
                    nodoUltimo = previo;
                }
                tamanio--;
                return dato;
            }
            previo = actual;
            actual = actual.getSiguienteNodo();
        }
        throw new RuntimeException("El elemento no existe");
    }

    public int obtenerPosicionNodo(T dato) {
        int i = 0;
        for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getSiguienteNodo()) {
            if (aux.getValorNodo().equals(dato)) return i;
            i++;
        }
        return -1;
    }

    public void imprimirLista() {
        Nodo<T> aux = nodoPrimero;
        while (aux != null) {
            System.out.print(aux.getValorNodo() + "\t");
            aux = aux.getSiguienteNodo();
        }
        System.out.println();
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamanio;
    }

    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public Nodo<T> getNodoUltimo() {
        return nodoUltimo;
    }
}
