package modelo;

import clase.Taxonomia;
import BD.Conexion;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ConsultasTaxonomia extends Conexion{
    ImageIcon foto;
    InputStream is;
    
    public boolean registrar(Taxonomia tax){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO taxonomias VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
            ps.setBinaryStream(15,tax.getImagenNom(),tax.getImagenTam());
            ps.setString(16, tax.getDescripcion());
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
                + "registrado=?, paleantologo=?, imagen=?, descripcion=? WHERE especie=?";
        
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
            ps.setBinaryStream(15,tax.getImagenNom(),tax.getImagenTam());
            ps.setString(16, tax.getDescripcion());
            ps.setString(17, especie);
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
                tax.setLeerImagen(rs.getBinaryStream("imagen"));
                tax.setDescripcion(rs.getString("descripcion"));
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

    
    public ArrayList<Taxonomia> coincidencias(String especie, String periodo, String pais){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Taxonomia> lista = new ArrayList();
        Taxonomia  tax = null;
        String sql=null;
        
        String especieAnt = null;
        String periodoAnt = null;
        String paisAnt = null;
        boolean banderaPais=true;
        
        String especieDes = null;
        String periodoDes= null;
        String paisDes = null;
        
        if(especie.isEmpty()){
            if(periodo.isEmpty()){
                if(pais.isEmpty()){
                    return lista;
                } else {
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE nombrepais='"+pais+"'";
                }
            } else {
                if(pais.isEmpty()){
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE periodo='"+periodo+"'";
                } else {
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE especie ILIKE '%"+especie+"%'"+
                        "AND periodo='"+periodo+"'"+
                        "AND nombrepais='"+pais+"'";
                }
            }
        } else {
            if(periodo.isEmpty()){
                if(pais.isEmpty()){
                    sql = "SELECT * FROM taxonomias_index "+
                            "WHERE especie ILIKE '%"+especie+"%'";
                } else {
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE especie ILIKE '%"+especie+"%'"+
                        "AND nombrepais='"+pais+"'";
                }
            } else {
                if(pais.isEmpty()){
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE especie ILIKE '%"+especie+"%'"+
                        "AND periodo='"+periodo+"'";
                } else {
                    sql = "SELECT * FROM taxonomias_index "+
                        "WHERE especie ILIKE '%"+especie+"%'"+
                        "AND periodo='"+periodo+"'"+
                        "AND nombrepais='"+pais+"'";
                }
            }
        }
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                especieAnt = rs.getString("especie");
                periodoAnt = rs.getString("periodo");
                paisAnt = rs.getString("nombrepais");
                tax = new Taxonomia(especieAnt,periodoAnt,paisAnt);
                lista.add(tax);
            } else {
                return lista;
            }
            
            while(rs.next()){
                especieDes = rs.getString("especie");
                periodoDes = rs.getString("periodo");
                paisDes = rs.getString("nombrepais");
                
                if(especieDes.equals(especieAnt)){
                    if(periodoDes.equals(periodoAnt)){
                        if(banderaPais){
                            tax.getListaPaises().add(paisDes);
                            paisAnt = paisDes;
                        }
                    } else {
                        tax.getListaPeriodos().add(periodoDes);
                        periodoAnt = periodoDes;
                        banderaPais=false;
                    }
                } else {
                    tax = new Taxonomia(especieDes,periodoDes,paisDes);
                    lista.add(tax);
                    especieAnt = especieDes;
                    periodoAnt = periodoDes;
                    paisAnt = paisDes;
                    banderaPais=true;
                }
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
    
    public ArrayList<Taxonomia> index(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Taxonomia> lista = new ArrayList();
        Taxonomia  tax = null;
        
        String especieAnt = null;
        String periodoAnt = null;
        String paisAnt = null;
        boolean banderaPais=true;
        
        String especieDes = null;
        String periodoDes= null;
        String paisDes = null;
        
        String sql = "SELECT * FROM taxonomias_index";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                especieAnt = rs.getString("especie");
                periodoAnt = rs.getString("periodo");
                paisAnt = rs.getString("nombrepais");
                tax = new Taxonomia(especieAnt,periodoAnt,paisAnt);
                lista.add(tax);
            } else {
                return lista;
            }
            
            while(rs.next()){
                especieDes = rs.getString("especie");
                periodoDes = rs.getString("periodo");
                paisDes = rs.getString("nombrepais");
                
                if(especieDes.equals(especieAnt)){
                    if(periodoDes.equals(periodoAnt)){
                        if(banderaPais){
                            tax.getListaPaises().add(paisDes);
                            paisAnt = paisDes;
                        }
                    } else {
                        tax.getListaPeriodos().add(periodoDes);
                        periodoAnt = periodoDes;
                        banderaPais=false;
                    }
                } else {
                    tax = new Taxonomia(especieDes,periodoDes,paisDes);
                    lista.add(tax);
                    especieAnt = especieDes;
                    periodoAnt = periodoDes;
                    paisAnt = paisDes;
                    banderaPais=true;
                }
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
