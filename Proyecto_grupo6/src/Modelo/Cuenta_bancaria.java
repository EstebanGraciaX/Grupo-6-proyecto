/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JT
 */
public class Cuenta_bancaria {
    private int id;
    private int n_cuenta;
    private String cliente;
    private String descripcion;
    

    public Cuenta_bancaria() {
    }

    public Cuenta_bancaria(int n_cuenta, String cliente, String descripcion) {
        this.n_cuenta = n_cuenta;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }

    public int getId() {
        return n_cuenta;
    }

    public void setId(int n_cuenta) {
        this.n_cuenta = n_cuenta;
    }

   
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
