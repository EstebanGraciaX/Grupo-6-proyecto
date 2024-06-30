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
public class Ciudad_de_entrega {
    private int id;
    private int codigo;
    private String nombre;
    
public Ciudad_de_entrega() {
    }

    public Ciudad_de_entrega(int id, int codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = codigo;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    }
