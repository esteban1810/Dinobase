package modelo;

import clase.Taxonomia;
import BD.Conexion;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ConsultasTaxonomia extends Conexion {

    ImageIcon foto;
    InputStream is;

    public boolean registrar(Taxonomia tax) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO taxonomias VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            ps.setBinaryStream(15, tax.getImagenNom(), tax.getImagenTam());
            ps.setString(16, tax.getDescripcion());
            ps.setString(17, tax.getImagenNom().toString());
            ps.setDouble(18, tax.getImagenTam());
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

    public boolean modificar(Taxonomia tax, String especie) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        System.out.println(tax.getImagenNom());
        if (tax.getImagenNom() != null) {
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
                ps.setBinaryStream(15, tax.getImagenNom(), tax.getImagenTam());
                
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
            String sql = "UPDATE taxonomias SET especie=?, reino=?, "
                    + "orden=?, dominio=?, familia=?, clase=?, filo=?,"
                    + "genero=?, altura=?, largo=?, peso=?, alimentacion=?,"
                    + "registrado=?, paleantologo=?, descripcion=? WHERE especie=?";
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
                ps.setString(15, tax.getDescripcion());
                ps.setString(16, especie);
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

    public boolean eliminar(Taxonomia tax) {
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

    public boolean buscar(Taxonomia tax) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM taxonomias WHERE especie=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tax.getEspecie());
            rs = ps.executeQuery();

            if (rs.next()) {
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
    
    public ArrayList<Taxonomia> coincidencias(String especie, String periodo, 
            String pais){
        
        String query = "SELECT especie,periodos,paises FROM index_visitante ";
        String concat=this.queryFiltrada(especie, periodo, pais);
        
        if(concat.isEmpty()){
            return null;
        }
        
        query+=concat.replaceFirst("AND", "WHERE");
        
        return this.toDoQuery(query, 2);
    }
    
    public String queryFiltrada(String especie, String periodo, String pais){
        String concat = "";
        
        concat+=especie.isEmpty()?"":"AND especie ILIKE '%"+especie+"%' ";
        concat+=periodo.isEmpty()?"":"AND periodos LIKE '%"+periodo+"%' ";
        concat+=pais.isEmpty()?"":"AND paises LIKE '%"+pais+"%' ";
        
        return concat;
    }
    
    public ArrayList<Taxonomia> coincidenciasVisitante(String especie,
            String paleontologo,String periodo,String pais){
        
        String query = "SELECT * FROM index_visitante ";
        String concat=this.queryFiltrada(especie, periodo, pais);
        
        concat+=paleontologo.isEmpty()?"":"AND paleontologo='"+paleontologo+"' ";
        
        if(concat.isEmpty()){
            return null;
        }
        
        query+=concat.replaceFirst("AND", "WHERE");
        
        return this.toDoQuery(query, 1);
    }
    
    public ArrayList<Taxonomia> index(){
        String query = "SELECT especie,periodos,paises FROM index_visitante";
        return this.toDoQuery(query, 2);
    }
    
    public ArrayList<Taxonomia> indexVisitante(){
        String query = "SELECT * FROM index_visitante";
        return this.toDoQuery(query,1);
    }
    
    public ArrayList<Taxonomia> toDoQuery(String query, int opc){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Taxonomia> lista = new ArrayList();
        Taxonomia  tax = null;
        
        
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            
            switch(opc){
                case 1:{
                    while(rs.next()){
                        tax = new Taxonomia();
                        tax.setEspecie(rs.getString(1));
                        tax.setPaleantologo(rs.getString(2));
                        tax.setPeriodos(rs.getString(3));
                        tax.setPaises(rs.getString(4));
                        lista.add(tax);
                    }
                }break;
                case 2: {
                    while(rs.next()){
                        tax = new Taxonomia();
                        tax.setEspecie(rs.getString(1));
                        tax.setPeriodos(rs.getString(2));
                        tax.setPaises(rs.getString(3));
                        lista.add(tax);
                    }
                }break;
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
