package modelo;

import clase.Tiempo;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Spinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerModel;

public class ConsultasTiempo  extends Conexion{
    
    public ArrayList<Tiempo> getTiempos(String taxonomia){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Tiempo tiempo = null;
        ArrayList<Tiempo> lista = new ArrayList();

        String sql = "SELECT * FROM uniontiempos WHERE especietax=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, taxonomia);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Tiempo tiem = new Tiempo();
                tiem.setPeriodo(rs.getString("periodo"));
                tiem.setEra(rs.getString("era"));
                tiem.setEpoca(rs.getString("epoca"));
                tiem.setDescubierto(rs.getString("descubierto"));
                lista.add(tiem);
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
    
    public boolean nombrePeriodos(JComboBox<String> periodoCB){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM tiempos ORDER BY periodo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                periodoCB.addItem(rs.getString("periodo"));
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
    
    public String getMenorAnio(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String minimo = "";
        
        String sql = "SELECT min(descubierto) minimo FROM tiempos";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                minimo = rs.getString("minimo");
            }
            
            return minimo;
        } catch (SQLException ex) {
            System.out.println(ex);
            return minimo;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public String getMayorAnio(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String maximo="";
        
        String sql = "SELECT max(descubierto) maximo FROM tiempos";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                maximo = rs.getString("maximo");
            }
            
            return maximo;
        } catch (SQLException ex) {
            System.out.println(ex);
            return maximo;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    
    
    public ArrayList<Tiempo> coincidencias(String periodo,String desde, String hasta){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Tiempo> lista = new ArrayList();
        String sql = null;
        
        if(periodo.isEmpty()){
            if(desde.isEmpty()){
                if(hasta.isEmpty()){
                    return null;
                } else {
                    sql = "SELECT * FROM tiempos WHERE descubierto<='"+hasta+"' ORDER BY periodo";
                }
            } else {
                if(hasta.isEmpty()){
                    sql = "SELECT * FROM tiempos WHERE descubierto>='"+desde+"' ORDER BY periodo";
                } else {
                    sql = "SELECT * FROM tiempos WHERE descubierto<='"+hasta+
                            "' AND descubierto>='"+desde+"' ORDER BY periodo";
                }
            }
        } else {
            if(desde.isEmpty()){
                if(hasta.isEmpty()){
                    sql = "SELECT * FROM tiempos WHERE periodo ILIKE '%"+periodo+
                            "%' ORDER BY periodo";
                } else {
                    sql = "SELECT * FROM tiempos WHERE periodo='%"+periodo+
                            "%' AND descubierto<='"+hasta+"' ORDER BY periodo";
                }
            } else {
                if(hasta.isEmpty()){
                    sql = "SELECT * FROM tiempos WHERE descubierto>='"+desde+
                            "' AND descubierto>='"+desde+"' ORDER BY periodo";
                } else {
                    sql = "SELECT * FROM tiempos WHERE periodo ILIKE '%"+periodo+
                            "%' AND descubierto<='"+hasta+
                            "' AND descubierto>='"+desde+"' ORDER BY periodo";
                }
            }
        }
        
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
