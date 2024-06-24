package persistencia;

import java.sql.*;
import java.util.*;
import negocio.TipoTransaccion;
import conexion.Conexion;

public class TipoTransaccionDAO {
    private Connection connection;

    public TipoTransaccionDAO() {
        connection = Conexion.getConnection();
    }

    public void saveTipoTransaccion(TipoTransaccion tipoTransaccion) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TipoTransaccion (codigo, nombre, signo) VALUES (?, ?, ?)");
            ps.setString(1, tipoTransaccion.getCodigo());
            ps.setString(2, tipoTransaccion.getNombre());
            ps.setString(3, String.valueOf(tipoTransaccion.getSigno()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TipoTransaccion> getAllTiposTransaccion() {
        List<TipoTransaccion> tiposTransaccion = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TipoTransaccion");
            while (rs.next()) {
                TipoTransaccion tipoTransaccion = new TipoTransaccion();
                tipoTransaccion.setId(rs.getInt("id"));
                tipoTransaccion.setCodigo(rs.getString("codigo"));
                tipoTransaccion.setNombre(rs.getString("nombre"));
                tipoTransaccion.setSigno(rs.getString("signo").charAt(0));
                tiposTransaccion.add(tipoTransaccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiposTransaccion;
    }
}
