package persistencia;

import java.sql.*;
import java.util.*;
import negocio.Cliente;
import conexion.Conexion;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        connection = Conexion.getConnection();
    }

    public void saveCliente(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cliente (ruc, nombre, direccion) VALUES (?, ?, ?)");
            ps.setString(1, cliente.getRuc());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setRuc(rs.getString("ruc"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente getClienteByName(String nombre) {
        Cliente cliente = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cliente WHERE nombre = ?");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setRuc(rs.getString("ruc"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
