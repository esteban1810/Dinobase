package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String usuario="postgres";
    private final String pass="Umbreon189";
    private final String BD="dinoBase";
    private final String host="localhost";
    private final String port="5432";
    private Connection con=null;

    public Connection getConnection(){
        String url= "jdbc:postgresql://" + host + ":" + port + "/" + BD; 
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }
}
