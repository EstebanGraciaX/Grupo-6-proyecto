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
public class Inventario {
    
    private int codigo;
    private String nombre;
    private String precio;
    

    public Inventario() {
    }

    public Inventario(int codigo, String nombre, String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return codigo;
    }

    public void setId(int codigo) {
        this.codigo = codigo;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getprecio() {
        return precio;
    }

    public void setprecio(String direccion) {
        this.precio = precio;
    }
    
}
