package recurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static void init() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario_db", "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
