package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame() {
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Gestión de Inventarios");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Pestaña de Inventarios
        JPanel inventariosPanel = new JPanel();
        inventariosPanel.setLayout(new BorderLayout());

        // Subpestañas de Inventarios
        JTabbedPane inventariosSubTabbedPane = new JTabbedPane();
        inventariosSubTabbedPane.add("Artículo", new ArticuloFrame());
        inventariosSubTabbedPane.add("Tipo Movimiento", new TipoMovimientoFrame());
        inventariosPanel.add(inventariosSubTabbedPane, BorderLayout.CENTER);

        tabbedPane.add("Inventarios", inventariosPanel);

        // Pestaña de Facturación
        JPanel facturacionPanel = new JPanel();
        facturacionPanel.setLayout(new BorderLayout());

        // Subpestañas de Facturación
        JTabbedPane facturacionSubTabbedPane = new JTabbedPane();
        facturacionSubTabbedPane.add("Cliente", new ClienteFrame());
        facturacionSubTabbedPane.add("Ciudad de Entrega", new CiudadFrame());
        facturacionPanel.add(facturacionSubTabbedPane, BorderLayout.CENTER);

        tabbedPane.add("Facturación", facturacionPanel);

        // Pestaña de Cuentas por Cobrar
        JPanel cuentasPorCobrarPanel = new JPanel();
        cuentasPorCobrarPanel.setLayout(new BorderLayout());

        // Subpestañas de Cuentas por Cobrar
        JTabbedPane cuentasPorCobrarSubTabbedPane = new JTabbedPane();
        cuentasPorCobrarSubTabbedPane.add("Cobrador", new CobradorFrame());
        cuentasPorCobrarSubTabbedPane.add("Forma de Pago", new FormaPagoFrame());
        cuentasPorCobrarPanel.add(cuentasPorCobrarSubTabbedPane, BorderLayout.CENTER);

        tabbedPane.add("Cuentas por Cobrar", cuentasPorCobrarPanel);

        // Pestaña de Bancos
        JPanel bancosPanel = new JPanel();
        bancosPanel.setLayout(new BorderLayout());

        // Subpestañas de Bancos
        JTabbedPane bancosSubTabbedPane = new JTabbedPane();
        bancosSubTabbedPane.add("Tipo de Transacción", new TipoTransaccionFrame());
        bancosSubTabbedPane.add("Cuenta Bancaria", new CuentaBancariaFrame());
        bancosPanel.add(bancosSubTabbedPane, BorderLayout.CENTER);

        tabbedPane.add("Bancos", bancosPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
