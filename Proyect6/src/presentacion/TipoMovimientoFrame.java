
package presentacion;

/**
 *
 * @author JT
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.TipoMovimiento;
import persistencia.TipoMovimientoDAO;
import escucha.TipoMovimientoListener;

    
public class TipoMovimientoFrame extends JPanel {
    private JTable table;
    private JTextField txtCodigo, txtNombre, txtSigno;
    private JButton btnGuardar;
    private TipoMovimientoDAO tipoMovimientoDAO;

    public TipoMovimientoFrame() {
        tipoMovimientoDAO = new TipoMovimientoDAO();
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

        btnGuardar.addActionListener(new TipoMovimientoListener(this));
    }

    private void loadData() {
        java.util.List<TipoMovimiento> tiposMovimiento = tipoMovimientoDAO.getAllTiposMovimiento();
        String[] columnNames = {"ID", "Código", "Nombre", "Signo"};
        String[][] data = new String[tiposMovimiento.size()][4];

        for (int i = 0; i < tiposMovimiento.size(); i++) {
            TipoMovimiento tipoMovimiento = tiposMovimiento.get(i);
            data[i][0] = String.valueOf(tipoMovimiento.getId());
            data[i][1] = tipoMovimiento.getCodigo();
            data[i][2] = tipoMovimiento.getNombre();
            data[i][3] = String.valueOf(tipoMovimiento.getSigno());
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
    
    
    
    