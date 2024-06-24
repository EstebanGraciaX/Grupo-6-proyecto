package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.Cobrador;
import persistencia.CobradorDAO;
import escucha.CobradorListener;

public class CobradorFrame extends JPanel {
    private JTable table;
    private JTextField txtCedula, txtNombre, txtDireccion;
    private JButton btnGuardar;
    private CobradorDAO cobradorDAO;

    public CobradorFrame() {
        cobradorDAO = new CobradorDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelForm.add(txtCedula);

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

        btnGuardar.addActionListener(new CobradorListener(this));
    }

    private void loadData() {
        List<Cobrador> cobradores = cobradorDAO.getAllCobradores();
        String[] columnNames = {"ID", "Cédula", "Nombre", "Dirección"};
        String[][] data = new String[cobradores.size()][4];

        for (int i = 0; i < cobradores.size(); i++) {
            Cobrador cobrador = cobradores.get(i);
            data[i][0] = String.valueOf(cobrador.getId());
            data[i][1] = cobrador.getCedula();
            data[i][2] = cobrador.getNombre();
            data[i][3] = cobrador.getDireccion();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public String getCedula() {
        return txtCedula.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }
}
