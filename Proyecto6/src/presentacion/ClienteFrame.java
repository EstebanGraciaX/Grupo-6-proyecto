/package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.Cliente;
import persistencia.ClienteDAO;
import escucha.ClienteListener;

public class ClienteFrame extends JPanel {
    private JTable table;
    private JTextField txtRuc, txtNombre, txtDireccion;
    private JButton btnGuardar;
    private ClienteDAO clienteDAO;

    public ClienteFrame() {
        clienteDAO = new ClienteDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("RUC:"));
        txtRuc = new JTextField();
        panelForm.add(txtRuc);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnGuardar.addActionListener(new ClienteListener(this));
    }

    private void loadData() {
        List<Cliente> clientes = clienteDAO.getAllClientes();
        String[] columnNames = {"ID", "RUC", "Nombre", "Dirección"};
        String[][] data = new String[clientes.size()][4];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = String.valueOf(cliente.getId());
            data[i][1] = cliente.getRuc();
            data[i][2] = cliente.getNombre();
            data[i][3] = cliente.getDireccion();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public String getRuc() {
        return txtRuc.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }
}
package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.Cliente;
import persistencia.ClienteDAO;
import escucha.ClienteListener;

public class ClienteFrame extends JPanel {
    private JTable table;
    private JTextField txtRuc, txtNombre, txtDireccion;
    private JButton btnGuardar;
    private ClienteDAO clienteDAO;

    public ClienteFrame() {
        clienteDAO = new ClienteDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("RUC:"));
        txtRuc = new JTextField();
        panelForm.add(txtRuc);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnGuardar.addActionListener(new ClienteListener(this));
    }

    private void loadData() {
        List<Cliente> clientes = clienteDAO.getAllClientes();
        String[] columnNames = {"ID", "RUC", "Nombre", "Dirección"};
        String[][] data = new String[clientes.size()][4];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = String.valueOf(cliente.getId());
            data[i][1] = cliente.getRuc();
            data[i][2] = cliente.getNombre();
            data[i][3] = cliente.getDireccion();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public String getRuc() {
        return txtRuc.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }
}

