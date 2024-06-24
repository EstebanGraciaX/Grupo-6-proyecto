package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.Ciudad;
import persistencia.CiudadDAO;
import escucha.CiudadListener;

public class CiudadFrame extends JPanel {
    private JTable table;
    private JTextField txtCodigo, txtNombre;
    private JButton btnGuardar;
    private CiudadDAO ciudadDAO;

    public CiudadFrame() {
        ciudadDAO = new CiudadDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(3, 2));
        panelForm.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelForm.add(txtCodigo);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnGuardar.addActionListener(new CiudadListener(this));
    }

    public void loadData() {
        List<Ciudad> ciudades = ciudadDAO.getAllCiudades();
        String[] columnNames = {"ID", "Código", "Nombre"};
        String[][] data = new String[ciudades.size()][3];

        for (int i = 0; i < ciudades.size(); i++) {
            Ciudad ciudad = ciudades.get(i);
            data[i][0] = String.valueOf(ciudad.getId());
            data[i][1] = ciudad.getCodigo();
            data[i][2] = ciudad.getNombre();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }
}
