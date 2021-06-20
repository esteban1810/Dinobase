package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Estoy haciendo pruebas
public class Conexion {
    private final String usuario="ycdoypbfcfozoq";
    private final String pass="cb38803f3ec4afbedeae58f996ca15690ce2256cf3eb6fb9e173b83847074312";
    private final String BD="dfetsmv4m7dl11";
    private final String host="ec2-3-91-127-228.compute-1.amazonaws.com";
    private final String port="5432";
    private Connection con=null;

    public Connection getConnection(){
        String url= "jdbc:postgresql://" + host + ":" + port + "/" + BD; 
        //String url2 = "postgres://"+usuario+":"+pass+"@"+host+":"+port+"/"+BD;
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }
}
