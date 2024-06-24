package persistencia;

import java.sql.*;
import java.util.*;
import negocio.FormaPago;
import conexion.Conexion;

public class FormaPagoDAO {
    private Connection connection;

    public FormaPagoDAO() {
        connection = Conexion.getConnection();
    }

    public void saveFormaPago(FormaPago formaPago) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO FormaPago (codigo, nombre) VALUES (?, ?)");
            ps.setString(1, formaPago.getCodigo());
            ps.setString(2, formaPago.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FormaPago> getAllFormasPago() {
        List<FormaPago> formasPago = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FormaPago");
            while (rs.next()) {
                FormaPago formaPago = new FormaPago();
                formaPago.setId(rs.getInt("id"));
                formaPago.setCodigo(rs.getString("codigo"));
                formaPago.setNombre(rs.getString("nombre"));
                formasPago.add(formaPago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formasPago;
    }
}
