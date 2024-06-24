package persistencia;

import java.sql.*;
import java.util.*;
import negocio.Ciudad;
import conexion.Conexion;

public class CiudadDAO {
    private Connection connection;

    public CiudadDAO() {
        connection = Conexion.getConnection();
    }

    public void saveCiudad(Ciudad ciudad) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Ciudad (codigo, nombre) VALUES (?, ?)");
            ps.setString(1, ciudad.getCodigo());
            ps.setString(2, ciudad.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ciudad> getAllCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ciudad");
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(rs.getInt("id"));
                ciudad.setCodigo(rs.getString("codigo"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudades.add(ciudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
    }
}
