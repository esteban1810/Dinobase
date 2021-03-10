package modelo;

import clase.Tiempo;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasTiempo  extends Conexion{
     public boolean registrar(Tiempo time){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO tiempos VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, time.getPeriodo());
            ps.setString(2, time.getEra());
            ps.setString(3, time.getEpoca());
            ps.setString(4, time.getDescubierto());
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
    
    public boolean modificar(Tiempo time, String tiempo){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE tiempos SET periodo=?, era=?, "
                + "epoca=?, descubierto=? WHERE periodo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, time.getPeriodo());
            ps.setString(2, time.getEra());
            ps.setString(3, time.getEpoca());
            ps.setString(4, time.getDescubierto());
            ps.setString(5, tiempo);
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

    public boolean eliminar(Tiempo time){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM tiempos WHERE periodo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, time.getPeriodo());
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
    
    public boolean buscar(Tiempo time){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM tiempos WHERE periodo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, time.getPeriodo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                time.setPeriodo(rs.getString("periodo"));
                time.setEra(rs.getString("era"));
                time.setEpoca(rs.getString("epoca"));
                time.setDescubierto(rs.getString("descubierto"));
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
    
    public boolean todosTiempos(ArrayList<Tiempo> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM tiempos ORDER BY periodo";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Tiempo tiem = new Tiempo();
                tiem.setPeriodo(rs.getString("periodo"));
                tiem.setEra(rs.getString("era"));
                tiem.setEpoca(rs.getString("epoca"));
                tiem.setDescubierto(rs.getString("descubierto"));
                lista.add(tiem);
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
    
    public boolean coincidencias(ArrayList<Tiempo> lista, String periodo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM tiempos WHERE periodo LIKE '%"+periodo+"%' ORDER BY periodo";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Tiempo tiem = new Tiempo();
                tiem.setPeriodo(rs.getString("periodo"));
                tiem.setEra(rs.getString("era"));
                tiem.setEpoca(rs.getString("epoca"));
                tiem.setDescubierto(rs.getString("descubierto"));
                lista.add(tiem);
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
