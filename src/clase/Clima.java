package clase;


public class Clima {
    private String nombre;
    private int humedad;
    private float presion;
    private float temperatura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public float getPresion() {
        return presion;
    }

    public void setPresion(float presion) {
        this.presion = presion;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    
    @Override
    public String toString() {
        return "Clima{" + "nombre=" + nombre + ", humedad=" + humedad + ", presion=" + presion + ", temperatura=" + temperatura + '}';
    }
    
    public Object[] arreglo(){
        Object[] arreglo = new Object[15];
        
        arreglo[0]=nombre;
        arreglo[1]=humedad;
        arreglo[2]=presion;
        arreglo[3]=temperatura;
        return arreglo;
    }
}

