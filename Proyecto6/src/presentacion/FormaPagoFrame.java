package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.FormaPago;
import persistencia.FormaPagoDAO;
import escucha.FormaPagoListener;

public class FormaPagoFrame extends JPanel {
    private JTable table;
    private JTextField txtCodigo, txtNombre;
    private JButton btnGuardar;
    private FormaPagoDAO formaPagoDAO;

    public FormaPagoFrame() {
        formaPagoDAO = new FormaPagoDAO();
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

        btnGuardar.addActionListener(new FormaPagoListener(this));
    }

    private void loadData() {
        List<FormaPago> formasPago = formaPagoDAO.getAllFormasPago();
        String[] columnNames = {"ID", "Código", "Nombre"};
        String[][] data = new String[formasPago.size()][3];

        for (int i = 0; i < formasPago.size(); i++) {
            FormaPago formaPago = formasPago.get(i);
            data[i][0] = String.valueOf(formaPago.getId());
            data[i][1] = formaPago.getCodigo();
            data[i][2] = formaPago.getNombre();
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
