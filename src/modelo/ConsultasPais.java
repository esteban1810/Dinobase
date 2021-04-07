package modelo;

import clase.Pais;
import BD.Conexion;
import clase.Clima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ConsultasPais extends Conexion{
    
    public ArrayList<Pais> getPaises(String taxonomia){
        PreparedStatement ps = null;
        ArrayList<Pais> lista=new ArrayList();
        ResultSet rs = null;
        Pais pais = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM unionpaises WHERE especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, taxonomia);
            rs = ps.executeQuery();
            
            while(rs.next()){
                pais = new Pais();
                pais.setNombre(rs.getString("nombre"));
                pais.setContinente(rs.getString("continente"));
                pais.setExtension(rs.getFloat("extension"));   
                lista.add(pais);
                
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex);
            return lista;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
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
    
    public boolean nombrePaises(JComboBox<String> paisCB){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        
        String sql = "SELECT nombre FROM paises ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                paisCB.addItem(rs.getString("nombre"));
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                System.out.println("todo OK");
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    
    
    public ArrayList<Pais> coincidencias(String nombre, String continente){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Pais> lista = new ArrayList();
        String sql = null;
        
        if(nombre.isEmpty()){
            if(continente.isEmpty()){
                return null;
            } else {
                sql = "SELECT * FROM paises WHERE continente='"+continente+"' ORDER BY nombre";
            }
        } else {
            if(continente.isEmpty()){
                sql = "SELECT * FROM paises WHERE nombre LIKE '%"+nombre+"%' ORDER BY nombre";
            } else {
                sql = "SELECT * FROM paises WHERE nombre LIKE '%"+nombre+"%' AND continente='"+continente+"' ORDER BY nombre";
            }
        }
        
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
