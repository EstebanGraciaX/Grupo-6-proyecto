package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArticuloFrame extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField precioField;
    private JButton guardarButton;

    public ArticuloFrame() {
        initComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Artículos");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void initComponents() {
        // Crear los componentes
        codigoField = new JTextField(20);
        nombreField = new JTextField(20);
        precioField = new JTextField(20);
        guardarButton = new JButton("Guardar");

        // Configurar el botón de guardar
        guardarButton.setActionCommand("Guardar");

        // Configurar el panel y disposición
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        mainPanel.add(new JLabel("Código:"), gbc);
        gbc.gridx++;
        mainPanel.add(codigoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx++;
        mainPanel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Precio:"), gbc);
        gbc.gridx++;
        mainPanel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(guardarButton, gbc);

        // Agregar el panel principal al frame
        getContentPane().add(mainPanel);
    }

    private void setupLayout() {
        // Configurar la disposición de los componentes
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(new JLabel("Código:"))
                        .addComponent(new JLabel("Nombre:"))
                        .addComponent(new JLabel("Precio:"))
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(codigoField)
                        .addComponent(nombreField)
                        .addComponent(precioField)
                        .addComponent(guardarButton)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(new JLabel("Código:"))
                        .addComponent(codigoField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(new JLabel("Nombre:"))
                        .addComponent(nombreField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(new JLabel("Precio:"))
                        .addComponent(precioField)
                )
                .addComponent(guardarButton)
        );
    }

    // Métodos para obtener datos de los campos
    public String getCodigo() {
        return codigoField.getText();
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public double getPrecio() {
        try {
            return Double.parseDouble(precioField.getText());
        } catch (NumberFormatException e) {
            return 0.0; // Manejo de error de conversión
        }
    }

    // Método para agregar ActionListener al botón Guardar
    public void addGuardarListener(ActionListener listener) {
        guardarButton.addActionListener(listener);
    }

    // Método principal para probar la interfaz
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArticuloFrame frame = new ArticuloFrame();
            frame.setVisible(true);
        });
    }
}
