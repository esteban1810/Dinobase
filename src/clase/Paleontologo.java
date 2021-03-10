

package clase;
import java.sql.Date;
public class Paleontologo {
    private String cedula;
    private String nombre;
    private String apellidos;
    private Date fechaN;

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaN() {
        return fechaN;
    }
    
    @Override
    public String toString() {
        return "Paleontologo{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaN=" + fechaN +  '}';
    }
    
    public Object[] arreglo(){
        Object[] arreglo = new Object[15];
        
        arreglo[0]=cedula;
        arreglo[1]=nombre;
        arreglo[2]=apellidos;
        arreglo[3]=fechaN;
        return arreglo;
    }
}