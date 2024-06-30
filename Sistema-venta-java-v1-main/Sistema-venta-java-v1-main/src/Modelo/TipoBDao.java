package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase DAO para la entidad TipoB.
 */
public class TipoBDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarTipoB(TipoB tipoB){
        String sql = "INSERT INTO tipo_b (codigo, nombre, tipo) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoB.getCodigo());
            ps.setString(2, tipoB.getNombre());
            ps.setString(3, tipoB.getTipo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List<TipoB> listarTipoB(){
        List<TipoB> listaTiposB = new ArrayList<>();
        String sql = "SELECT * FROM tipo_b";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoB tipoB = new TipoB();
                tipoB.setId(rs.getInt("id"));
                tipoB.setCodigo(rs.getString("codigo"));
                tipoB.setNombre(rs.getString("nombre"));
                tipoB.setTipo(rs.getString("tipo"));
                listaTiposB.add(tipoB);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaTiposB;
    }

    public boolean eliminarTipoB(int id){
        String sql = "DELETE FROM tipo_b WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean modificarTipoB(TipoB tipoB){
        String sql = "UPDATE tipo_b SET codigo=?, nombre=?, tipo=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoB.getCodigo());
            ps.setString(2, tipoB.getNombre());
            ps.setString(3, tipoB.getTipo());
            ps.setInt(4, tipoB.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public TipoB buscarTipoB(int id){
        TipoB tipoB = new TipoB();
        String sql = "SELECT * FROM tipo_b WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipoB.setId(rs.getInt("id"));
                tipoB.setCodigo(rs.getString("codigo"));
                tipoB.setNombre(rs.getString("nombre"));
                tipoB.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return tipoB;
    }
}