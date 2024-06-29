
package Modelo;

public class Facturacion {
    private int ruc;
    private String nombre;
    private String direccion;
    
    public Facturacion(){
        
    }

    public Facturacion(int ruc, String nombre, String direccion) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return ruc;
    }

    public void setId(int id) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
  } 


    

