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
public class Tipo_de_transaccion {
    
    private int codigo;
    private String nombre;
    private String signo;
    

    public Tipo_de_transaccion() {
    }

    public Tipo_de_transaccion(int codigo, String nombre, String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.signo = signo;
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

    public String getsigno() {
        return signo;
    }

    public void setsigno(String signo) {
        this.signo = signo;
    }
    
}
