package main;

import recurso.DBConnection;
import presentacion.MainFrame;

public class Main {
    public static void main(String[] args) {
        // Inicializar la conexión a la base de datos
        DBConnection.init();

        // Crear y mostrar la ventana principal de la aplicación
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
