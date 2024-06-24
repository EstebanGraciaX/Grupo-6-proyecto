package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.TipoTransaccion;
import persistencia.TipoTransaccionDAO;
import escucha.TipoTransaccionListener;

public class TipoTransaccionFrame extends JPanel {
    private JTable table;
    private JTextField txtCodigo, txtNombre, txtSigno;
    private JButton btnGuardar;
    private TipoTransaccionDAO tipoTransaccionDAO;

    public TipoTransaccionFrame() {
        tipoTransaccionDAO = new TipoTransaccionDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelForm.add(txtCodigo);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Signo:"));
        txtSigno = new JTextField();
        panelForm.add(txtSigno);

        btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnGuardar.addActionListener(new TipoTransaccionListener(this));
    }

    public void loadData() {
        List<TipoTransaccion> tiposTransaccion = tipoTransaccionDAO.getAllTiposTransaccion();
        String[] columnNames = {"ID", "Código", "Nombre", "Signo"};
        String[][] data = new String[tiposTransaccion.size()][4];

        for (int i = 0; i < tiposTransaccion.size(); i++) {
            TipoTransaccion tipoTransaccion = tiposTransaccion.get(i);
            data[i][0] = String.valueOf(tipoTransaccion.getId());
            data[i][1] = tipoTransaccion.getCodigo();
            data[i][2] = tipoTransaccion.getNombre();
            data[i][3] = String.valueOf(tipoTransaccion.getSigno());
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getSigno() {
        return txtSigno.getText();
    }
}
