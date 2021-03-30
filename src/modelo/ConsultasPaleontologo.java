package modelo;

import clase.Paleontologo;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasPaleontologo extends Conexion{
    
    public boolean registrar(Paleontologo paleo){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO paleantologos VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paleo.getCedula());
            ps.setString(2, paleo.getNombre());
            ps.setString(3, paleo.getApellidos());
            ps.setDate(4, paleo.getFechaN());
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
    
    public boolean modificar(Paleontologo paleo, String cedula){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE paleantologos SET cedula=?, nombre=?, "
                + "apellidos=?, fechan=? WHERE cedula=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paleo.getCedula());
            ps.setString(2, paleo.getNombre());
            ps.setString(3, paleo.getApellidos());
            ps.setDate(4, paleo.getFechaN());
            ps.setString(5, cedula);
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

    public boolean eliminar(Paleontologo paleo){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM paleantologos WHERE cedula=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paleo.getCedula());
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
    
    public boolean buscar(Paleontologo paleo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM paleantologos WHERE cedula=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paleo.getCedula());
            rs = ps.executeQuery();
            
            if(rs.next()){
                paleo.setCedula(rs.getString("cedula"));
                paleo.setNombre(rs.getString("nombre"));
                paleo.setApellidos(rs.getString("apellidos"));
                paleo.setFechaN(rs.getDate("fechan"));
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
    
    public boolean todosPaleontologos(ArrayList<Paleontologo> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM paleantologos ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Paleontologo paleo = new Paleontologo();
                paleo.setNombre(rs.getString("nombre"));
                paleo.setApellidos(rs.getString("apellidos"));
                paleo.setCedula(rs.getString("cedula"));
                paleo.setFechaN(rs.getDate("fechan"));
                lista.add(paleo);
            }
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
    
    public ArrayList<Paleontologo> coincidencias(String cadena){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Paleontologo> lista = new ArrayList();
        Paleontologo paleo;
        
        String sql = "SELECT * FROM paleantologos WHERE cedula ILIKE '%"+cadena+"%' OR CONCAT(nombre,' ',apellidos) ILIKE '%"+cadena+"%' ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                paleo = new Paleontologo();
                paleo.setNombre(rs.getString("nombre"));
                paleo.setApellidos(rs.getString("apellidos"));
                paleo.setCedula(rs.getString("cedula"));
                paleo.setFechaN(rs.getDate("fechan"));
                lista.add(paleo);
            }
            return lista;
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

