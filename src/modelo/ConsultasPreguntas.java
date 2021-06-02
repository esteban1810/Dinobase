/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Conexion;
import clase.Preguntas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class ConsultasPreguntas extends Conexion {
     public Boolean buscar(ArrayList<Preguntas> lista, String dificultad) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM preguntas";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Preguntas question = new Preguntas(); 
                question.setNumero(rs.getInt(1));
                question.setPregunta(rs.getString(2));
                question.setDificultad(rs.getString(3));
                question.setPuntos(rs.getInt(4));
                question.setEstado(rs.getInt(5));
                if(dificultad.equals(question.getDificultad())){
                    lista.add(question);
                }
                 
            }
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }
         return false;
     }
}
