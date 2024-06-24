package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ClienteControlador;
import vista.ClienteFrame;

public class ClienteListener implements ActionListener {
    private final ClienteFrame frame;
    private final ClienteControlador controlador;

    public ClienteListener(ClienteFrame frame, ClienteControlador controlador) {
        this.frame = frame;
        this.controlador = controlador;
    }

    public ClienteListener(presentacion.ClienteFrame aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Guardar":
                controlador.guardarCliente();
                break;
            case "Eliminar":
                controlador.eliminarCliente();
                break;
            case "Modificar":
                controlador.modificarCliente();
                break;
            case "Buscar":
                controlador.buscarCliente();
                break;
        }
    }
}
