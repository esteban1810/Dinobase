package modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasTaxo_Pais extends Conexion{
    
    public boolean registrar(String especie, Object[] tiempos){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO taxonomia_pais VALUES(?,?)";
        
        for(int i=0; i<tiempos.length; i++){
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, especie);
                ps.setString(2, tiempos[i].toString());
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
    
    public boolean modificar(String especie, Object[] tiempos){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM taxonomia_pais WHERE especietax=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
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
        
        this.registrar(especie, tiempos);
        
        return true;
    }
    
    public ArrayList getRelacionesPais(String especie){
        PreparedStatement ps = null;
        ArrayList<String> lista=new ArrayList();
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT nombrepais FROM taxonomia_pais WHERE especietax=? ORDER BY nombrepais";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(rs.getString("nombrepais"));
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
}
