package aplicacion;

import recurso.DBConnection;
import presentacion.MainFrame;

public class aplicacion {
    public static void main(String[] args) {
        // Inicializar la conexión a la base de datos
        DBConnection.init();

        // Crear y mostrar la ventana principal de la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
