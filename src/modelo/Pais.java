package modelo;

public class Pais {
    private String nombre;
    private String continente;
    private float extension;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }
    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", continente=" + continente + ", extension=" + extension + '}';
    }
    
     public Object[] arreglo(){
        Object[] arreglo = new Object[15];
        
        arreglo[0]=nombre;
        arreglo[1]=continente;
        arreglo[2]=extension;        
        return arreglo;
    }
}
