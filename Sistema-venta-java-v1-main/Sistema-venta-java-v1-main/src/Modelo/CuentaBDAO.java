package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase DAO para la entidad CuentaBancaria.
 */
public class CuentaBDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarCuenta(CuentaB cuenta){
        String sql = "INSERT INTO cuenta_bancaria (id_cliente, descripcion) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cuenta.getCliente().getId());
            ps.setString(2, cuenta.getDescripcion());
            ps.executeUpdate();

            // Obtener el ID generado automáticamente
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cuenta.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List<CuentaB> listarCuentas(){
        List<CuentaB> listaCuentas = new ArrayList<>();
        String sql = "SELECT cb.id as cuenta_id, cb.descripcion as cuenta_desc, c.id as cliente_id, c.dni, c.nombre, c.telefono, c.direccion " +
                     "FROM cuenta_bancaria cb " +
                     "INNER JOIN clientes c ON cb.id_cliente = c.id";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));

                CuentaB cuenta = new CuentaB();
                cuenta.setId(rs.getInt("cuenta_id"));
                cuenta.setCliente(cliente);
                cuenta.setDescripcion(rs.getString("cuenta_desc"));

                listaCuentas.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return listaCuentas;
    }

    public boolean eliminarCuenta(int id){
        String sql = "DELETE FROM cuenta_bancaria WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean modificarCuenta(CuentaB cuenta){
        String sql = "UPDATE cuenta_bancaria SET id_cliente=?, descripcion=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cuenta.getCliente().getId());
            ps.setString(2, cuenta.getDescripcion());
            ps.setInt(3, cuenta.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public CuentaB buscarCuenta(int id){
        CuentaB cuenta = null;
        String sql = "SELECT cb.id as cuenta_id, cb.descripcion as cuenta_desc, c.id as cliente_id, c.dni, c.nombre, c.telefono, c.direccion " +
                     "FROM cuenta_bancaria cb " +
                     "INNER JOIN clientes c ON cb.id_cliente = c.id " +
                     "WHERE cb.id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));

                cuenta = new CuentaB();
                cuenta.setId(rs.getInt("cuenta_id"));
                cuenta.setCliente(cliente);
                cuenta.setDescripcion(rs.getString("cuenta_desc"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return cuenta;
    }
}