package vista;

import javax.swing.*;
import java.awt.*;

public class ClienteFrame extends JPanel {
    private JTextField txtRuc, txtNombre, txtDireccion;
    private JButton btnGuardar, btnEliminar, btnModificar, btnBuscar;

    public ClienteFrame() {
        initComponents();
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

        add(panelForm, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnEliminar = new JButton("Eliminar");
        btnModificar = new JButton("Modificar");
        btnBuscar = new JButton("Buscar");

        panelButtons.add(btnGuardar);
        panelButtons.add(btnEliminar);
        panelButtons.add(btnModificar);
        panelButtons.add(btnBuscar);

        add(panelButtons, BorderLayout.SOUTH);
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

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
}
