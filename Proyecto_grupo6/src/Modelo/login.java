
package Modelo;

public class login {
    private int id;
    private String usuario;
    private String password;
    
    public login() {
    }

    public login(int id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        
}
