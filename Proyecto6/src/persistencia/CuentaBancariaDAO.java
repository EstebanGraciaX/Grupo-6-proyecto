package persistencia;

import java.sql.*;
import java.util.*;
import negocio.CuentaBancaria;
import negocio.Cliente;
import conexion.Conexion;

public class CuentaBancariaDAO {
    private Connection connection;

    public CuentaBancariaDAO() {
        connection = Conexion.getConnection();
    }

    public void saveCuentaBancaria(CuentaBancaria cuentaBancaria) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO CuentaBancaria (numeroCuenta, clienteId, descripcion) VALUES (?, ?, ?)");
            ps.setString(1, cuentaBancaria.getNumeroCuenta());
            ps.setInt(2, cuentaBancaria.getCliente().getId());
            ps.setString(3, cuentaBancaria.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CuentaBancaria> getAllCuentasBancarias() {
        List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CuentaBancaria");
            while (rs.next()) {
                CuentaBancaria cuentaBancaria = new CuentaBancaria();
                cuentaBancaria.setId(rs.getInt("id"));
                cuentaBancaria.setNumeroCuenta(rs.getString("numeroCuenta"));
                cuentaBancaria.setDescripcion(rs.getString("descripcion"));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("clienteId"));
                cuentaBancaria.setCliente(cliente);

                cuentasBancarias.add(cuentaBancaria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentasBancarias;
    }
}
