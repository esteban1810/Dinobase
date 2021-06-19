package modelo;

import clase.Usuario;
import BD.Conexion;
import clase.Taxonomia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasUsuario extends Conexion{
    
    public boolean registrar(Usuario user){
        PreparedStatement ps;
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
    public Usuario PuntajeAnterior(String nickname){
        PreparedStatement ps;
        Usuario user = null;
        ResultSet rs;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Usuario();
                user.setNickname(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
                user.setCorreo(rs.getString("correo"));
                user.setFechaN(rs.getDate("fechan"));
                user.setTipoU(rs.getString("tipou"));
                user.setPuntaje(rs.getInt("puntaje"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void puntajeNuevo(int puntaje, String nombre){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE usuarios SET puntaje=? WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, puntaje);
            ps.setString(2, nombre);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
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
                user.setPuntaje(rs.getInt("puntaje"));
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
    
    public Usuario validarUsuario(String nickname, String pass){
        PreparedStatement ps;
        Usuario user = null;
        ResultSet rs;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE nickname=? and pass=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Usuario();
                user.setNickname(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
                user.setCorreo(rs.getString("correo"));
                user.setFechaN(rs.getDate("fechan"));
                user.setTipoU(rs.getString("tipou"));
                user.setPuntaje(rs.getInt("puntaje"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public ArrayList<Usuario> Estadisticas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Usuario> usuarios = new ArrayList();
        
        String sql = "SELECT * FROM usuarios WHERE tipou=? order by puntaje";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "Visitante");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario();
                user.setNickname(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
                user.setCorreo(rs.getString("correo"));
                user.setFechaN(rs.getDate("fechan"));
                user.setTipoU(rs.getString("tipou"));
                user.setPuntaje(rs.getInt("puntaje"));               
                usuarios.add(user);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
}
