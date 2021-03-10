package modelo;

import clase.Clima;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasClima extends Conexion{
     public boolean registrar(Clima clima){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO climas VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clima.getNombre());
            ps.setInt(2, clima.getHumedad());
            ps.setFloat(3, clima.getPresion()); 
            ps.setFloat(4, clima.getTemperatura());             
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
    
    public boolean modificar(Clima clima, String nombre){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE climas SET nombre=?, humedad=?, "
                + "presion=?, temperatura=? WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clima.getNombre());
            ps.setInt(2, clima.getHumedad());
            ps.setFloat(3, clima.getPresion()); 
            ps.setFloat(4, clima.getTemperatura()); 
            ps.setString(5, nombre);
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
    
    public boolean eliminar(Clima clima){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM climas WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clima.getNombre());
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
    
    public String[] buscar(Clima clima){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM climas WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clima.getNombre());
            rs = ps.executeQuery();
            
            if(rs.next()){
                String[] a={rs.getString("nombre"),rs.getString("humedad"),rs.getString("presion"),rs.getString("temperatura")};
                clima.setNombre(a[0]);
                clima.setHumedad(Integer.parseInt(a[1]));
                clima.setPresion(Float.parseFloat(a[2]));
                clima.setTemperatura(Float.parseFloat(a[3])); 
                
                return a;
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
    
    public ArrayList dinoListaClima(ArrayList<Clima> listaclim){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM climas";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Clima clim = new Clima();
                clim.setNombre(rs.getString("nombre"));
                clim.setHumedad(Integer.parseInt(rs.getString("humedad")));
                clim.setPresion(Float.parseFloat(rs.getString("presion")));
                clim.setTemperatura(Float.parseFloat(rs.getString("temperatura")));
                listaclim.add(clim);
                System.out.println("pasa");
            }
            return listaclim;
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
    
    public boolean todosClimas(ArrayList<Clima> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM climas ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Clima clima = new Clima();   
                clima.setNombre(rs.getString("nombre"));
                clima.setHumedad(Integer.parseInt(rs.getString("humedad")));
                clima.setPresion(Float.parseFloat(rs.getString("presion")));
                clima.setTemperatura(Float.parseFloat(rs.getString("temperatura")));
                lista.add(clima);                                
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
    
    public boolean coincidencias(ArrayList<Clima> lista, String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM climas WHERE nombre LIKE '%"+nombre+"%' ORDER BY nombre";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                Clima clima = new Clima();   
                clima.setNombre(rs.getString("nombre"));
                clima.setHumedad(Integer.parseInt(rs.getString("humedad")));
                clima.setPresion(Float.parseFloat(rs.getString("presion")));
                clima.setTemperatura(Float.parseFloat(rs.getString("temperatura")));
                lista.add(clima);                                                                 
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
