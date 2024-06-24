package controlador;

import negocio.Cliente;
import persistencia.ClienteDAO;

public class ClienteControlador {
    private final ClienteDAO clienteDAO;

    public ClienteControlador() {
        this.clienteDAO = new ClienteDAO();
    }

    public void guardarCliente(Cliente cliente) {
        return clienteDAO.saveCliente(cliente);
    }

    public boolean eliminarCliente(Cliente cliente) {
        return clienteDAO.deleteCliente(cliente);
    }

    public boolean modificarCliente(Cliente cliente) {
        return clienteDAO.updateCliente(cliente);
    }

    public Cliente buscarCliente(String ruc) {
        return clienteDAO.findClienteByRuc(ruc);
    }
}
