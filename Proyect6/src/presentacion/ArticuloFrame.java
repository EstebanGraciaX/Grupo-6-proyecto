package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import negocio.Articulo;
import persistencia.ArticuloDAO;
import escucha.ArticuloListener;

public class ArticuloFrame extends JFrame {
    private JTable table;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private ArticuloDAO articuloDAO;

    public ArticuloFrame() {
        articuloDAO = new ArticuloDAO();
        setTitle("Artículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setActionCommand("Guardar");
        btnGuardar.addActionListener(new ArticuloListener(this));
        panel.add(btnGuardar);

        add(panel, BorderLayout.NORTH);

        List<Articulo> articulos = articuloDAO.getAllArticulos();
        String[] columnNames = {"ID", "Código", "Nombre", "Precio"};
        Object[][] data = new Object[articulos.size()][4];

        for (int i = 0; i < articulos.size(); i++) {
            Articulo articulo = articulos.get(i);
            data[i][0] = articulo.getId();
            data[i][1] = articulo.getCodigo();
            data[i][2] = articulo.getNombre();
            data[i][3] = articulo.getPrecio();
        }

        table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public double getPrecio() {
        return Double.parseDouble(txtPrecio.getText());
    }
}
