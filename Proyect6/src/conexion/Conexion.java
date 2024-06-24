package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto6_db", "usuario", "contraseña");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

