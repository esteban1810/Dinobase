package modelo;

import clase.RegistroVisitante;
import clase.Tiempo;
import clase.Pais;
import clase.Clima;
import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasRegistrosV  extends Conexion{
    
    public ArrayList buscarTiempos(String especie){
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String periodo;
        
        String sql = "SELECT periodo FROM uniontiempos where especietax=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
            rs = ps.executeQuery();
            while(rs.next()){
                periodo=new String();
                periodo=rs.getString("periodo");
                lista.add(periodo);
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
    public String buscarPaleo(String cedula){
        String nombreP = new String();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String nombre;
        
        String sql = "SELECT nombre FROM uniontaxpaleo WHERE paleantologo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombre=new String();
                nombre=rs.getString("nombre");
                nombreP = nombre;
            }
            return nombreP;
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
    
    public ArrayList<Tiempo> buscarTiemposFull(String especie){
        ArrayList<Tiempo> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Tiempo tiempo;
        
        String sql = "SELECT periodo,era,epoca,descubierto FROM uniontiempos where especietax=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
            rs = ps.executeQuery();
            while(rs.next()){
                tiempo=new Tiempo();
                tiempo.setPeriodo(rs.getString("periodo"));
                tiempo.setEra(rs.getString("era"));
                tiempo.setEpoca(rs.getString("epoca"));
                tiempo.setDescubierto(rs.getString("descubierto"));
                lista.add(tiempo);
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
    
     public ArrayList<Pais> buscarPaisesFull(String especie){
        ArrayList<Pais> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Pais pais;
        
        String sql = "SELECT nombre,continente,extension FROM unionpaises where especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
            rs = ps.executeQuery();
            while(rs.next()){
                pais =new Pais();
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
    
    public ArrayList buscarPaises(String especie){
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String nombre;
        
        String sql = "SELECT nombre FROM unionpaises WHERE especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, especie);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombre=new String();
                nombre=rs.getString("nombre");
                lista.add(nombre);
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
    
    public ArrayList todosRegistros(){
        ArrayList<RegistroVisitante> lista = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        RegistroVisitante rv;
        
        String sql = "SELECT * FROM taxonomias ORDER BY especie";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                rv = new RegistroVisitante();
                rv.setEspecie(rs.getString("especie"));
                rv.setRegistrado(rs.getString("registrado"));
                rv.setPaleontologo(rs.getString("paleantologo"));
                rv.setPeriodos(this.buscarTiempos(rs.getString("especie")));
                rv.setPaises(this.buscarPaises(rs.getString("especie")));
                lista.add(rv);
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
    
     public ArrayList coincidencias(ArrayList<RegistroVisitante> lista,     String especie){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        RegistroVisitante rv;
        
        String sql = "SELECT * FROM taxonomias WHERE especie LIKE '%"+especie+"%' ORDER BY especie";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                rv = new RegistroVisitante();
                rv.setEspecie(rs.getString("especie"));
                rv.setRegistrado(rs.getString("registrado"));
                rv.setPaleontologo(rs.getString("paleantologo"));
                rv.setPeriodos(this.buscarTiempos(rs.getString("especie")));
                rv.setPaises(this.buscarPaises(rs.getString("especie")));
                lista.add(rv);
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
        
//        
    }
    
    public ArrayList<Clima> buscarClimasFull(String nombrepais){
        ArrayList<Clima> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Clima clima;
        
        String sql = "SELECT nombrepais, nombreclima, humedad, presion, temperatura FROM unionpais_clima where nombrepais=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombrepais);
            rs = ps.executeQuery();
            while(rs.next()){
                clima =new Clima();
                clima.setNombre(rs.getString("nombreclima"));
                clima.setHumedad(rs.getInt("humedad"));
                clima.setPresion(rs.getFloat("presion"));
                clima.setTemperatura(rs.getFloat("temperatura"));
                lista.add(clima);
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
 
