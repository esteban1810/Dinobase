package clase;

public class Tiempo {
    private String periodo;
    private String era;
    private String epoca;
    private String descubierto;

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public void setDescubierto(String descubierto) {
        this.descubierto = descubierto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getEra() {
        return era;
    }

    public String getEpoca() {
        return epoca;
    }

    public String getDescubierto() {
        return descubierto;
    }
    
    @Override
    public String toString() {
        return "Tiempo{" + "periodo=" + periodo + ", era=" + era + ", epoca=" + epoca + ", descubierto=" + descubierto +'}';
    }
    
     public Object[] arreglo(){
        Object[] arreglo = new Object[15];
        
        arreglo[0]=periodo;
        arreglo[1]=era;
        arreglo[2]=epoca;
        arreglo[3]=descubierto;
        return arreglo;
    }
}
