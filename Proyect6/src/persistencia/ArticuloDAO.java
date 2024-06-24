package persistencia;

import negocio.Articulo;
import recurso.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
    public List<Articulo> getAllArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        String query = "SELECT * FROM articulos";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(resultSet.getInt("id"));
                articulo.setCodigo(resultSet.getString("codigo"));
                articulo.setNombre(resultSet.getString("nombre"));
                articulo.setPrecio(resultSet.getDouble("precio"));
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articulos;
    }

    public void saveArticulo(Articulo articulo) {
        String query = "INSERT INTO articulos (codigo, nombre, precio) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, articulo.getCodigo());
            statement.setString(2, articulo.getNombre());
            statement.setDouble(3, articulo.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos CRUD adicionales
}
