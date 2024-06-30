package Modelo;

/**
 * Clase que representa la entidad CuentaBancaria.
 */
public class CuentaB {
    private int id;
    private Cliente cliente;
    private String descripcion;

    public CuentaB() {
    }

    public CuentaB(int id, Cliente cliente, String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CuentaB{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}