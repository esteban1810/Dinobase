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
    
    public ArrayList<Clima> getClimas(String pais){
        PreparedStatement ps = null;
        ArrayList<Clima> lista=new ArrayList();
        ResultSet rs = null;
        Clima clima = null;
        Connection con = getConnection();
        
        String sql = "SELECT nombre,humedad,presion,temperatura FROM unionpais_clima WHERE nombrepais=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais);
            rs = ps.executeQuery();
            
            while(rs.next()){
                clima = new Clima();
                clima.setNombre(rs.getString(1));
                clima.setHumedad(rs.getInt(2));
                clima.setPresion(rs.getFloat(3));
                clima.setTemperatura(rs.getFloat(4));
                lista.add(clima);
                
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
    
    
    public Clima buscar(String nombreClima){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Clima clima = new Clima();
        
        String sql = "SELECT * FROM climas WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreClima);
            rs = ps.executeQuery();
            
            if(rs.next()){
                clima.setNombre(rs.getString(1));
                clima.setHumedad(rs.getInt(2));
                clima.setPresion(rs.getFloat(3));
                clima.setTemperatura(rs.getFloat(4)); 
                return clima;
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
