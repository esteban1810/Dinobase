package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultasPais_Clima extends Conexion{
    
    public boolean registrar(String nombre, Object[] climas){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO pais_clima VALUES(?,?)";
        
        for(int i=0; i<climas.length; i++){
            try {
                System.out.println(climas[i].toString());
                ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, climas[i].toString());
                ps.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasTaxo_Pais.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }          
    
    public ArrayList getRelacionesClima(String pais){
        PreparedStatement ps = null;
        ArrayList<String> lista=new ArrayList();
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT nombreclima FROM pais_clima WHERE nombrepais=? ORDER BY nombreclima";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(rs.getString("nombreclima"));
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
    
    public boolean modificar(String nombre, Object[] climas){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM pais_clima WHERE nombrepais=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.execute();
            
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
        
        this.registrar(nombre, climas);
        
        return true;
    }
    
    public boolean buscar(Pais pais){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM pais_clima WHERE nombrepais=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pais.setNombre(rs.getString("nombre"));                             
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