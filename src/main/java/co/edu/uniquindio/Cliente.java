package co.edu.uniquindio;

public class Cliente implements Comparable<Cliente> {
    private int id;
    private String nombre;
    private String email;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Cliente otro) {
        return this.getNombre().compareTo(otro.getNombre());
    }

    @Override
    public String toString() {
        return "Cliente{id='" + id + "', nombre='" + nombre + "', email='" + email + "'}";
    }
}
