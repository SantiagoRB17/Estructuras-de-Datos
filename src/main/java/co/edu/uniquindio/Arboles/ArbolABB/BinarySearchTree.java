package co.edu.uniquindio.Arboles.ArbolABB;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        int comparison = data.compareTo(node.getData());
        if (comparison < 0) {
            node.setLeft(addRecursive(node.getLeft(), data));
        } else if (comparison > 0) {
            node.setRight(addRecursive(node.getRight(), data));
        }
        return node;
    }

    public String traverseInOrder() {
        StringBuilder builder = new StringBuilder();
        traverseInOrderRecursive(root, builder);
        return builder.toString().trim();
    }

    private void traverseInOrderRecursive(Node<T> node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        traverseInOrderRecursive(node.getLeft(), builder);
        builder.append(node.getData()).append(" ");
        traverseInOrderRecursive(node.getRight(), builder);
    }

    public String traversePreOrder() {
        StringBuilder builder = new StringBuilder();
        traversePreOrderRecursive(root, builder);
        return builder.toString().trim();
    }

    private void traversePreOrderRecursive(Node<T> node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        builder.append(node.getData()).append(" ");
        traversePreOrderRecursive(node.getLeft(), builder);
        traversePreOrderRecursive(node.getRight(), builder);
    }

    public String traversePostOrder() {
        StringBuilder builder = new StringBuilder();
        traversePostOrderRecursive(root, builder);
        return builder.toString().trim();
    }

    private void traversePostOrderRecursive(Node<T> node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        traversePostOrderRecursive(node.getLeft(), builder);
        traversePostOrderRecursive(node.getRight(), builder);
        builder.append(node.getData()).append(" ");
    }

    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int comparison = data.compareTo(node.getData());
        if (comparison == 0) {
            return true;
        }
        if (comparison < 0) {
            return containsRecursive(node.getLeft(), data);
        }
        return containsRecursive(node.getRight(), data);
    }

    public int getWeight() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRecursive(node.getLeft()) + countNodesRecursive(node.getRight());
    }

    public int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeightRecursive(node.getLeft()), getHeightRecursive(node.getRight()));
    }

    public int getLevel() {
        if (isEmpty()) {
            return 0;
        }
        return getHeight() - 1;
    }

    public int countLeaves() {
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        return countLeavesRecursive(node.getLeft()) + countLeavesRecursive(node.getRight());
    }

    public T getMinimum() {
        return getMinimumNode();
    }

    public T getMinimumNode() {
        if (isEmpty()) {
            return null;
        }
        Node<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    public T getMaximumNode() {
        if (isEmpty()) {
            return null;
        }
        Node<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    public String printBreadth() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            builder.append(current.getData()).append(" ");

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return builder.toString().trim();
    }

    public void remove(T data) {
        root = removeRecursive(root, data);
    }

    private Node<T> removeRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        int comparison = data.compareTo(node.getData());
        if (comparison < 0) {
            node.setLeft(removeRecursive(node.getLeft(), data));
            return node;
        }
        if (comparison > 0) {
            node.setRight(removeRecursive(node.getRight(), data));
            return node;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        if (node.getRight() == null) {
            return node.getLeft();
        }

        T successorValue = getMinimumFrom(node.getRight());
        node.setData(successorValue);
        node.setRight(removeRecursive(node.getRight(), successorValue));
        return node;
    }

    private T getMinimumFrom(Node<T> node) {
        Node<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    public void clear() {
        root = null;
    }

    Node<T> getRoot() {
        return root;
    }

    // Spanish aliases mapped to the English API.
    public boolean estaVacio() {
        return isEmpty();
    }

    public void agregarDato(T data) {
        add(data);
    }

    public String recorrerInorden() {
        return traverseInOrder();
    }

    public String recorrerPreorden() {
        return traversePreOrder();
    }

    public String recorrerPostorden() {
        return traversePostOrder();
    }

    public boolean existeDato(T data) {
        return contains(data);
    }

    public int obtenerPeso() {
        return getWeight();
    }

    public int obtenerAltura() {
        return getHeight();
    }

    public int obtenerNivel() {
        return getLevel();
    }

    public int contarHojas() {
        return countLeaves();
    }

    public T obtenerMenor() {
        return getMinimum();
    }

    public String imprimirAmplitud() {
        return printBreadth();
    }

    public void eliminarDato(T data) {
        remove(data);
    }

    public T obtenerNodoMayor() {
        return getMaximumNode();
    }

    public T obtenerNodoMenor() {
        return getMinimumNode();
    }

    public void borrarArbol() {
        clear();
    }
}
