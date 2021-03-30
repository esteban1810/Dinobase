package clase;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Taxonomia {
    private String especie;
    private String reino;
    private String orden;
    private String dominio;
    private String familia;
    private String clase;
    private String filo;
    private String genero;
    private double altura;
    private double largo;
    private double peso;
    private String alimentacion;
    private String registrado;
    private String paleantologo;
    private int imagenTam;
    private FileInputStream imagenNom;
    private InputStream leerImagen;
    private String descripcion;
    private ArrayList<String> listaPaises;
    private ArrayList<String> listaPeriodos;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputStream getLeerImagen() {
        return leerImagen;
    }

    public void setLeerImagen(InputStream leerImagen) {
        this.leerImagen = leerImagen;
    }
    public FileInputStream getImagenNom() {
        return imagenNom;
    }

    public void setImagenNom(FileInputStream imagenNom) {
        this.imagenNom = imagenNom;
    }

    public int getImagenTam() {
        return imagenTam;
    }

    public void setImagenTam(int imagen) {
        this.imagenTam = imagen;
    }
    
    public Taxonomia(){
        listaPaises = new ArrayList<>();
        listaPeriodos = new ArrayList<>();
    }
    
    public Taxonomia(String especie, String periodo, String pais){
        listaPaises = new ArrayList<>();
        listaPeriodos = new ArrayList<>();
        this.especie=especie;
        this.listaPaises.add(pais);
        this.listaPeriodos.add(periodo);
    }

    public ArrayList<String> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<String> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public ArrayList<String> getListaPeriodos() {
        return listaPeriodos;
    }

    public void setListaPeriodos(ArrayList<String> listaPeriodos) {
        this.listaPeriodos = listaPeriodos;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public String getPaleantologo() {
        return paleantologo;
    }

    public void setPaleantologo(String paleantologo) {
        this.paleantologo = paleantologo;
    }

    @Override
    public String toString() {
        return "Taxonomia{" + "especie=" + especie + ", reino=" + reino + ", orden=" + orden + ", dominio=" + dominio + ", familia=" + familia + ", clase=" + clase + ", filo=" + filo + ", genero=" + genero + ", altura=" + altura + ", largo=" + largo + ", peso=" + peso + ", alimentacion=" + alimentacion + ", registrado=" + registrado + ", paleantologo=" + paleantologo + ", imagenTam=" + imagenTam + ", imagenNom=" + imagenNom + '}';
    }
    
    public Object[] arreglo(){
        Object[] arreglo = new Object[15];
        String paises="";
        String periodos="";
        
        for(String pais : listaPaises){
            paises+=pais+", ";
        }
        paises=paises.substring(0, paises.length()-2);
        for(String periodo : listaPeriodos){
            periodos+=periodo+", ";
        }
        periodos=periodos.substring(0, periodos.length()-2);
        
        arreglo[0]="";
        arreglo[1]=especie;
        arreglo[2]=periodos;
        arreglo[3]=paises;
        
        return arreglo;
    }
}
