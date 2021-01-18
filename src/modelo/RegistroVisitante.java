package modelo;

import java.util.ArrayList;

public class RegistroVisitante{
    private String especie;
    private String registrado;
    private String paleontologo;
    private ArrayList<String> periodos;
    private ArrayList<String> paises;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public String getPaleontologo() {
        return paleontologo;
    }

    public void setPaleontologo(String paleontologo) {
        this.paleontologo = paleontologo;
    }

    public ArrayList<String> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(ArrayList<String> periodos) {
        this.periodos = periodos;
    }

    public ArrayList<String> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<String> paises) {
        this.paises = paises;
    }

    @Override
    public String toString() {
        return "RegistroVisitante{" + "especie=" + especie + ", registrado=" + registrado + ", paleontologo=" + paleontologo + ", tiempos=" + periodos + ", paises=" + paises + '}';
    }
    
    public String getStringPeriodos(){
        String cadena;
            
        if(periodos.isEmpty()){
            return null;
        }
        
        cadena = periodos.get(0);
        
        for(int i=1; i<periodos.size(); i++){
            cadena += ", "+periodos.get(i);
        }
        
        return cadena;
    }
    public String getStringPaises(){
        String cadena;
            
        if(paises.isEmpty()){
            return null;
        }
        
        cadena = paises.get(0);
        
        for(int i=1; i<paises.size(); i++){
            cadena += ", "+paises.get(i);
        }
        
        return cadena;
    }
    
    
     public Object[] arreglo(){
        Object[] arreglo = new Object[5];
        
        arreglo[0]=especie;
        arreglo[1]=registrado;
        arreglo[2]=paleontologo;
        arreglo[3]= getStringPeriodos();
        arreglo[4]=getStringPaises();
            
        return arreglo;
    }
}
