package BD;
import java.sql.*;

public class ConexionPostgreSQL {
    
    public boolean conexionPostgres(String host, String port, String database, 
            String usuario, String pass){

        //Url a nuestro base de datos
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database; 
        boolean valid;
        
        try { 
            //Estamos registrando el driver de postgreSQL
            Class.forName("org.postgresql.Driver");
            System.out.println("exito1");
        } catch (ClassNotFoundException ex) {
            return false;
        }
        
        try {
            //Nos conectamos a la base de datos
            Connection connection = DriverManager.getConnection(url,usuario,pass);
            
            //Sirve para comprobar que la conexion se haya realizado con exito
            valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            
//            PreparedStatement pst = connection.prepareStatement("insert into paises values(?,?,?)");
//            pst.setString(1, "1");
//            pst.setString(2, "1");
//            pst.setInt(3, 1);
//            
//            System.out.println("entra");
//            System.out.println((int)pst.executeUpdate());
//            System.out.println("entra");
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
        
        return true;
    }
    
}