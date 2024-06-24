package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.CuentaBancaria;
import negocio.Cliente;
import persistencia.CuentaBancariaDAO;
import persistencia.ClienteDAO;
import presentacion.CuentaBancariaFrame;

public class CuentaBancariaListener implements ActionListener {
    private CuentaBancariaFrame frame;
    private CuentaBancariaDAO cuentaBancariaDAO;
    private ClienteDAO clienteDAO;

    public CuentaBancariaListener(CuentaBancariaFrame frame) {
        this.frame = frame;
        this.cuentaBancariaDAO = new CuentaBancariaDAO();
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        cuentaBancaria.setNumeroCuenta(frame.getNumeroCuenta());
        cuentaBancaria.setDescripcion(frame.getDescripcion());

        String clienteNombre = frame.getCliente();
        Cliente cliente = clienteDAO.getClienteByName(clienteNombre);
        cuentaBancaria.setCliente(cliente);

        cuentaBancariaDAO.saveCuentaBancaria(cuentaBancaria);
        frame.loadData();
    }
}