package controlador;

import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import clase.Clima;
import modelo.ConsultasRegistrosV;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import view.visitante.VisitanteForm;
import view.visitante.VisitanteIndex;

public final class RegistroVisitanteCtrl implements ActionListener{
    private ConsultasRegistrosV visitanteMod;
    private VisitanteIndex visitanteIndex;
    private ArrayList<Taxonomia> listaVisitante;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    private VisitanteForm visitanteForm;
    
    public RegistroVisitanteCtrl(){
        visitanteMod     = new ConsultasRegistrosV();
        visitanteIndex  = new VisitanteIndex();
        modelo          = new DefaultTableModel();
        modelo2         = new DefaultTableModel();
        modelo3         = new DefaultTableModel();
        visitanteForm   = new VisitanteForm();
        
        this.visitanteIndex.buscarBtn.addActionListener(this);
        this.visitanteIndex.mostrarBtn.addActionListener(this);
        this.visitanteIndex.todoBtn.addActionListener(this);
        this.visitanteForm.regresarBtn.addActionListener(this);
        this.visitanteIndex.setLocationRelativeTo(null);
        this.visitanteForm.setLocationRelativeTo(null);
        this.visitanteForm.mostrarClimaBtn.addActionListener(this);
        
        
        listaVisitante = visitanteMod.todosRegistros();
        cargarPeriodoCB();
        cargarPaisCB();
        cargarPaleontologoCB();
        cargarTabla();
    }
    
    public void cargarPeriodoCB(){
        new ConsultasTiempo().nombrePeriodos(visitanteIndex.periodoCB);
    }
    
    public void cargarPaisCB(){
        new ConsultasPais().nombrePaises(visitanteIndex.paisCB);
    }
    
    public void cargarPaleontologoCB(){
        new ConsultasPaleontologo().paleontologos(visitanteIndex.paleontologoCB);
    }
    
    public void iniciar(){
        visitanteIndex.setVisible(true);
        visitanteIndex.setTitle("Tiempo");
        visitanteIndex.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == visitanteIndex.todoBtn) {
            listaVisitante = visitanteMod.todosRegistros();
            cargarTabla();
        } 
            
        else if (e.getSource() == visitanteForm.mostrarClimaBtn){
            mostrarClimaBtn();
        }
        
        else if (e.getSource() == visitanteIndex.mostrarBtn) {
            mostrarBtn();
        } 
//         
        else if (visitanteForm.regresarBtn == e.getSource()) {
            visitanteForm.setVisible(false);
            visitanteIndex.setVisible(true);
            cargarTabla();
        } 
//        
        else if (e.getSource() == visitanteIndex.buscarBtn) {
            buscarBtn();
        } 
  
    }
    
    public void buscarBtn(){
        String pais     = visitanteIndex.paisCB.getSelectedItem().toString();
        String periodo  = visitanteIndex.periodoCB.getSelectedItem().toString();
        String paleonto  = visitanteIndex.paleontologoCB.getSelectedItem().toString();
        String especie  = visitanteIndex.buscarTF.getText();
        ArrayList<Taxonomia> listaAux;

        
        if(pais.equals("-- Seleccionar --")){
            pais="";
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
                if(paleonto.equals("-- Seleccionar --")){
                    paleonto="";
                    if(especie.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Especifique algún campo de búsqueda");
                        return;
                    }
                }
            } else {
                if(paleonto.equals("-- Seleccionar --")){
                    paleonto="";
                }
            }
        } else {
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
                if(paleonto.equals("-- Seleccionar --")){
                    paleonto="";
                }
            } else {
                if(paleonto.equals("-- Seleccionar --")){
                    paleonto="";
                }
            }
        }
        
        listaVisitante=visitanteMod.coincidencias(especie, paleonto, periodo, pais);

        if (listaVisitante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            return;
        }
        cargarTabla();
    }
    
    public void cargarTabla(){
       modelo = new DefaultTableModel();
       visitanteIndex.tablaTaxonomias2.setModel(modelo);
       Object[] fila;

       modelo.addColumn("Especie");
       modelo.addColumn("Paleontologo");
       modelo.addColumn("Tiempos");
       modelo.addColumn("Paises");

       for(int i=0; i<listaVisitante.size(); i++){
           fila = listaVisitante.get(i).arregloVisitante();
           modelo.addRow(fila);
       }
   }

    public void limpiarTabla(){
        int filas=modelo.getRowCount();
        System.out.println(modelo.getRowCount());
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
    }

    private void mostrarClimaBtn() {
        int fila = visitanteForm.tablaPaises.getSelectedRow();
        ArrayList<Clima> listaT = new ArrayList();
        modelo3 =new DefaultTableModel();
        visitanteForm.climaLbl.setVisible(true);
        visitanteForm.tablaClimas.setModel(modelo3);

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }

        modelo3.addColumn("Nombre");
        modelo3.addColumn("Humedad");
        modelo3.addColumn("Presion");
        modelo3.addColumn("Temperatura");

        Pais mod = new Pais();
        mod.setNombre(visitanteForm.tablaPaises.getValueAt(fila, 0).toString());
        listaT = visitanteMod.buscarClimasFull(mod.getNombre());

        for (int i = 0; i < listaT.size(); i++) {
            modelo3.addRow(listaT.get(i).arreglo());
        }
    }

    private void mostrarBtn() {
        int fila = visitanteIndex.tablaTaxonomias2.getSelectedRow();
        Object[] renglon = new Object[4];
        ArrayList<Tiempo> listaT = new ArrayList();
        ArrayList<Pais> listaT1 = new ArrayList();
        modelo=new DefaultTableModel();
        modelo2 = new DefaultTableModel();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        ConsultasTaxonomia modT = new ConsultasTaxonomia();
        Taxonomia mod = new Taxonomia();

        mod.setEspecie(visitanteIndex.tablaTaxonomias2.getValueAt(fila, 0).toString());
        modT.buscar(mod);

        visitanteForm.especieTF.setText(mod.getEspecie());
        visitanteForm.reinoTF.setText(mod.getReino());
        visitanteForm.ordenTF.setText(mod.getOrden());
        visitanteForm.dominioTF.setText(mod.getDominio());
        visitanteForm.familiaTF.setText(mod.getFamilia());
        visitanteForm.claseTF.setText(mod.getClase());
        visitanteForm.filoTF.setText(mod.getFilo());
        visitanteForm.generoTF.setText(mod.getGenero());
        visitanteForm.alturaTF.setText(Double.toString(mod.getAltura()));
        visitanteForm.largoTF.setText(Double.toString(mod.getLargo()));
        visitanteForm.pesoTF.setText(Double.toString(mod.getPeso()));
        visitanteForm.alimentacionTF.setText(mod.getAlimentacion());
        visitanteForm.registradoTF.setText(mod.getRegistrado());
        visitanteForm.paleantologoTF.setText(mod.getPaleantologo());

        visitanteForm.setVisible(true);
        visitanteIndex.setVisible(false);

        visitanteForm.tablaTiempos.setModel(modelo);

        modelo.addColumn("Periodo");
        modelo.addColumn("Era");
        modelo.addColumn("Epoca");
        modelo.addColumn("Descubierto");

        listaT = visitanteMod.buscarTiemposFull(mod.getEspecie());

        for (int i = 0; i < listaT.size(); i++) {
            modelo.addRow(listaT.get(i).arreglo());
        }

        visitanteForm.tablaPaises.setModel(modelo2);

        modelo2.addColumn("Pais");
        modelo2.addColumn("Continente");
        modelo2.addColumn("Extension");

        listaT1 = visitanteMod.buscarPaisesFull(mod.getEspecie());

        for (int i = 0; i < listaT1.size(); i++) {
            modelo2.addRow(listaT1.get(i).arreglo());
        }
    }
   
}
