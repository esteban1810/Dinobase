package modelo;

import clase.Pais;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasPais extends Conexion{
    
    public boolean registrar(Pais pais){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO paises VALUES(?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getContinente());
            ps.setFloat(3, pais.getExtension());             
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
    
    public boolean modificar(Pais pais, String nombre){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE paises SET nombre=?, continente=?, "
                + "extension=? WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getContinente());            
            ps.setFloat(3, pais.getExtension());
            ps.setString(4, nombre);
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
    
    public boolean eliminar(Pais pais){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM paises WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
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
    
    public Pais buscar(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Pais pais = null;
        
        String sql = "SELECT * FROM paises WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if(rs.next()){
                pais = new Pais();
                pais.setNombre(rs.getString("nombre"));
                pais.setContinente(rs.getString("continente"));
                pais.setExtension(rs.getFloat("extension"));          
                return pais;
            }
            return null;
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
    
    public ArrayList dinoListaPais(ArrayList<Pais> listaPais){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM paises";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Pais pais = new Pais();
                pais.setNombre(rs.getString("nombre"));
                pais.setContinente(rs.getString("continente"));
                pais.setExtension(Float.parseFloat(rs.getString("extension")));                
                listaPais.add(pais);
            }
            return listaPais;
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
    
    public boolean todosPaises(ArrayList<Pais> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM paises ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Pais pais = new Pais();
                pais.setNombre(rs.getString("nombre"));
                pais.setContinente(rs.getString("continente"));
                pais.setExtension(rs.getFloat("extension"));
                lista.add(pais);
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
    
    public boolean coincidencias(ArrayList<Pais> lista, String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM paises WHERE nombre LIKE '%"+nombre+"%' ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Pais pais = new Pais();
                pais.setNombre(rs.getString("nombre"));
                pais.setContinente(rs.getString("continente"));
                pais.setExtension(rs.getFloat("extension"));
                                               
                lista.add(pais);
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
    
}
