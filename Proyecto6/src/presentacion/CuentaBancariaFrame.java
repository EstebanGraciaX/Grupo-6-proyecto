package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.CuentaBancaria;
import negocio.Cliente;
import persistencia.CuentaBancariaDAO;
import persistencia.ClienteDAO;
import escucha.CuentaBancariaListener;

public class CuentaBancariaFrame extends JPanel {
    private JTable table;
    private JTextField txtNumeroCuenta, txtDescripcion;
    private JComboBox<String> comboCliente;
    private JButton btnGuardar;
    private CuentaBancariaDAO cuentaBancariaDAO;
    private ClienteDAO clienteDAO;

    public CuentaBancariaFrame() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
        clienteDAO = new ClienteDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("Número de Cuenta:"));
        txtNumeroCuenta = new JTextField();
        panelForm.add(txtNumeroCuenta);

        panelForm.add(new JLabel("Cliente:"));
        comboCliente = new JComboBox<>();
        panelForm.add(comboCliente);

        panelForm.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelForm.add(txtDescripcion);

        btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnGuardar.addActionListener(new CuentaBancariaListener(this));
    }

    private void loadData() {
        List<CuentaBancaria> cuentasBancarias = cuentaBancariaDAO.getAllCuentasBancarias();
        String[] columnNames = {"ID", "Número de Cuenta", "Cliente", "Descripción"};
        String[][] data = new String[cuentasBancarias.size()][4];

        for (int i = 0; i < cuentasBancarias.size(); i++) {
            CuentaBancaria cuentaBancaria = cuentasBancarias.get(i);
            data[i][0] = String.valueOf(cuentaBancaria.getId());
            data[i][1] = cuentaBancaria.getNumeroCuenta();
            data[i][2] = cuentaBancaria.getCliente().getNombre();
            data[i][3] = cuentaBancaria.getDescripcion();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));

        List<Cliente> clientes = clienteDAO.getAllClientes();
        for (Cliente cliente : clientes) {
            comboCliente.addItem(cliente.getNombre());
        }
    }

    public String getNumeroCuenta() {
        return txtNumeroCuenta.getText();
    }

    public String getDescripcion() {
        return txtDescripcion.getText();
    }

    public String getCliente() {
        return (String) comboCliente.getSelectedItem();
    }
}
