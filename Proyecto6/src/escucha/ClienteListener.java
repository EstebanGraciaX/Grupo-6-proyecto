package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Cliente;
import persistencia.ClienteDAO;
import presentacion.ClienteFrame;

public class ClienteListener implements ActionListener {
    private ClienteFrame frame;
    private ClienteDAO clienteDAO;

    public ClienteListener(ClienteFrame frame) {
        this.frame = frame;
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setRuc(frame.getRuc());
        cliente.setNombre(frame.getNombre());
        cliente.setDireccion(frame.getDireccion());

        clienteDAO.saveCliente(cliente);
        frame.loadData();
    }
}
