package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ConsultasUsuario extends Conexion{
    
    public boolean registrar(Usuario user){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getPass());
            ps.setDate(3, user.getFechaN());
            ps.setString(4, user.getCorreo());
            ps.setString(5, user.getTipoU());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public boolean modificar(Usuario user){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE usuarios SET nickname=?, pass=?, "
                + "fechan=?, correo=?, tipou=? WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getPass());
            ps.setDate(3, user.getFechaN());
            ps.setString(4, user.getCorreo());
            ps.setString(5, user.getTipoU());
            ps.setString(6, user.getNickname());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }

    public boolean eliminar(Usuario user){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM usuarios WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNickname());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public boolean buscar(Usuario user){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNickname());
            rs = ps.executeQuery();
            
            if(rs.next()){
                user.setNickname(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
                user.setCorreo(rs.getString("correo"));
                user.setFechaN(rs.getDate("fechan"));
                user.setTipoU(rs.getString("tipou"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
}
