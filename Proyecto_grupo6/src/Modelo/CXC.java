
package Modelo;

public class CXC {
    private int cedula;
    private String nombre;
    private String direccion;
    
    public CXC(){
        
    }

    public CXC(int cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return cedula;
    }

    public void setId(int cedula) {
        this.cedula = cedula;
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
