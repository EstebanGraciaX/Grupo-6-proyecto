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
public class Forma_de_pago {
    
    private int codigo;
    private String nombre;
   

public Forma_de_pago(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        
    }
    
    public int getId() {
        return codigo;
    }

    public void setId(int id) {
        this.codigo = codigo;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}