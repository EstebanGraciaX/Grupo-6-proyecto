package persistencia;

import java.sql.*;
import java.util.*;
import negocio.Cobrador;
import conexion.Conexion;

public class CobradorDAO {
    private Connection connection;

    public CobradorDAO() {
        connection = Conexion.getConnection();
    }

    public void saveCobrador(Cobrador cobrador) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cobrador (cedula, nombre, direccion) VALUES (?, ?, ?)");
            ps.setString(1, cobrador.getCedula());
            ps.setString(2, cobrador.getNombre());
            ps.setString(3, cobrador.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cobrador> getAllCobradores() {
        List<Cobrador> cobradores = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cobrador");
            while (rs.next()) {
                Cobrador cobrador = new Cobrador();
                cobrador.setId(rs.getInt("id"));
                cobrador.setCedula(rs.getString("cedula"));
                cobrador.setNombre(rs.getString("nombre"));
                cobrador.setDireccion(rs.getString("direccion"));
                cobradores.add(cobrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobradores;
    }
}
