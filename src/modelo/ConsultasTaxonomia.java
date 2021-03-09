package modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasTaxonomia extends Conexion{
    
    public boolean registrar(Taxonomia tax){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO taxonomias VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tax.getEspecie());
            ps.setString(2, tax.getReino());
            ps.setString(3, tax.getOrden());
            ps.setString(4, tax.getDominio());
            ps.setString(5, tax.getFamilia());
            ps.setString(6, tax.getClase());
            ps.setString(7, tax.getFilo());
            ps.setString(8, tax.getGenero());
            ps.setDouble(9, tax.getAltura());
            ps.setDouble(10, tax.getLargo());
            ps.setDouble(11, tax.getPeso());
            ps.setString(12, tax.getAlimentacion());
            ps.setString(13, tax.getRegistrado());
            ps.setString(14, tax.getPaleantologo());
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
    
    public boolean modificar(Taxonomia tax, String especie){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE taxonomias SET especie=?, reino=?, "
                + "orden=?, dominio=?, familia=?, clase=?, filo=?,"
                + "genero=?, altura=?, largo=?, peso=?, alimentacion=?,"
                + "registrado=?, paleantologo=? WHERE especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tax.getEspecie());
            ps.setString(2, tax.getReino());
            ps.setString(3, tax.getOrden());
            ps.setString(4, tax.getDominio());
            ps.setString(5, tax.getFamilia());
            ps.setString(6, tax.getClase());
            ps.setString(7, tax.getFilo());
            ps.setString(8, tax.getGenero());
            ps.setDouble(9, tax.getAltura());
            ps.setDouble(10, tax.getLargo());
            ps.setDouble(11, tax.getPeso());
            ps.setString(12, tax.getAlimentacion());
            ps.setString(13, tax.getRegistrado());
            ps.setString(14, tax.getPaleantologo());
            ps.setString(15, especie);
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

    public boolean eliminar(Taxonomia tax){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM taxonomias WHERE especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tax.getEspecie());
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
    
    public boolean buscar(Taxonomia tax){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM taxonomias WHERE especie=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tax.getEspecie());
            rs = ps.executeQuery();
            
            if(rs.next()){
                tax.setEspecie(rs.getString("especie"));
                tax.setReino(rs.getString("reino"));
                tax.setOrden(rs.getString("orden"));
                tax.setDominio(rs.getString("dominio"));
                tax.setFamilia(rs.getString("familia"));
                tax.setClase(rs.getString("clase"));
                tax.setFilo(rs.getString("filo"));
                tax.setGenero(rs.getString("genero"));
                tax.setAltura(rs.getDouble("altura"));
                tax.setLargo(rs.getDouble("largo"));
                tax.setPeso(rs.getDouble("peso"));
                tax.setAlimentacion(rs.getString("alimentacion"));
                tax.setRegistrado(rs.getString("registrado"));
                tax.setPaleantologo(rs.getString("paleantologo"));
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

    public boolean todasTaxonomias(ArrayList<Taxonomia> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM taxonomias ORDER BY especie";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Taxonomia tax = new Taxonomia();
                tax.setEspecie(rs.getString("especie"));
                tax.setReino(rs.getString("reino"));
                tax.setOrden(rs.getString("orden"));
                tax.setDominio(rs.getString("dominio"));
                tax.setFamilia(rs.getString("familia"));
                tax.setClase(rs.getString("clase"));
                tax.setFilo(rs.getString("filo"));
                tax.setGenero(rs.getString("genero"));
                tax.setAltura(rs.getDouble("altura"));
                tax.setLargo(rs.getDouble("largo"));
                tax.setPeso(rs.getDouble("peso"));
                tax.setAlimentacion(rs.getString("alimentacion"));
                tax.setRegistrado(rs.getString("registrado"));
                tax.setPaleantologo(rs.getString("paleantologo"));
                lista.add(tax);
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
    
    public boolean coincidencias(ArrayList<Taxonomia> lista, String especie){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM taxonomias WHERE especie LIKE '%"+especie+"%' ORDER BY especie";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Taxonomia tax = new Taxonomia();
                tax.setEspecie(rs.getString("especie"));
                tax.setReino(rs.getString("reino"));
                tax.setOrden(rs.getString("orden"));
                tax.setDominio(rs.getString("dominio"));
                tax.setFamilia(rs.getString("familia"));
                tax.setClase(rs.getString("clase"));
                tax.setFilo(rs.getString("filo"));
                tax.setGenero(rs.getString("genero"));
                tax.setAltura(rs.getDouble("altura"));
                tax.setLargo(rs.getDouble("largo"));
                tax.setPeso(rs.getDouble("peso"));
                tax.setAlimentacion(rs.getString("alimentacion"));
                tax.setRegistrado(rs.getString("registrado"));
                tax.setPaleantologo(rs.getString("paleantologo"));
                lista.add(tax);
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
    
    public boolean index(ArrayList<Taxonomia> lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        lista.clear();
        
        String sql = "SELECT * FROM taxonomias ORDER BY especie";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Taxonomia tax = new Taxonomia();
                tax.setEspecie(rs.getString("especie"));
                tax.setReino(rs.getString("reino"));
                tax.setOrden(rs.getString("orden"));
                tax.setDominio(rs.getString("dominio"));
                tax.setFamilia(rs.getString("familia"));
                tax.setClase(rs.getString("clase"));
                tax.setFilo(rs.getString("filo"));
                tax.setGenero(rs.getString("genero"));
                tax.setAltura(rs.getDouble("altura"));
                tax.setLargo(rs.getDouble("largo"));
                tax.setPeso(rs.getDouble("peso"));
                tax.setAlimentacion(rs.getString("alimentacion"));
                tax.setRegistrado(rs.getString("registrado"));
                tax.setPaleantologo(rs.getString("paleantologo"));
                lista.add(tax);
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
