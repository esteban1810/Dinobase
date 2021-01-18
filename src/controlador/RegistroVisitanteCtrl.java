package controlador;

import modelo.ConsultasRegistrosV;
import framesTiempo.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import modelo.RegistroVisitante;
import framesVisitante.FormVisitante1;
import framesVisitante.IndexVisitante1;

public class RegistroVisitanteCtrl implements ActionListener{
    private ConsultasRegistrosV modC;
    private IndexVisitante1 frm;
    private ArrayList<RegistroVisitante> listaRV;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    private FormVisitante1 fv;
//    private RegistroVisitante mod;
    
//    private TiempoRegistro frmReg;
//    private static DefaultListModel listaR;
//    private ArrayList<Tiempo> lista;
//    private DefaultListModel modeloList;
    
    public RegistroVisitanteCtrl(){
//        this.mod=mod;
        this.modC=new ConsultasRegistrosV();
        
        this.frm=new IndexVisitante1();
//        frmReg = new TiempoRegistro();
        modelo = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        fv = new FormVisitante1();
//        listaR = new DefaultListModel();
//        lista = new ArrayList();
        
        this.frm.buscarBtn.addActionListener(this);
        this.frm.mostrarBtn.addActionListener(this);
        this.frm.todoBtn.addActionListener(this);
        this.fv.regresarBtn.addActionListener(this);
        this.frm.mostrarPaleoBtn.addActionListener(this);
        this.frm.setLocationRelativeTo(null);
        this.fv.setLocationRelativeTo(null);
        this.fv.mostrarClimaBtn.addActionListener(this);
        
        
        listaRV = modC.todosRegistros();
        cargarTabla();
    }
    
//    public static DefaultListModel getListaR(){
//        return listaR;
//    }
    
    public void iniciar(){
        frm.setVisible(true);
        frm.setTitle("Tiempo");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        if (e.getSource() == frm.todoBtn) {
            listaRV = modC.todosRegistros();
            cargarTabla();
        } 
        
         else if (e.getSource() == frm.mostrarPaleoBtn){
            int fila = frm.tablaTaxonomias2.getSelectedRow();
            String nombrePaleo;
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            Taxonomia modT = new Taxonomia();
            modT.setPaleantologo(frm.tablaTaxonomias2.getValueAt(fila, 2).toString());
            nombrePaleo = modC.buscarPaleo(modT.getPaleantologo());
            
           JOptionPane.showMessageDialog(null, "La cedula " + modT.getPaleantologo()+ "pertenece a " + nombrePaleo);
        }
            
        else if (e.getSource() == fv.mostrarClimaBtn){
            int fila = fv.tablaPaises.getSelectedRow();
            ArrayList<Clima> listaT = new ArrayList();
            modelo3 =new DefaultTableModel();
            fv.climaLbl.setVisible(true);
            fv.tablaClimas.setModel(modelo3);
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            modelo3.addColumn("Nombre");
            modelo3.addColumn("Humedad");
            modelo3.addColumn("Presion");
            modelo3.addColumn("Temperatura");
            
            Pais mod = new Pais();
            mod.setNombre(fv.tablaPaises.getValueAt(fila, 0).toString());
            listaT = modC.buscarClimasFull(mod.getNombre());

            for (int i = 0; i < listaT.size(); i++) {
                modelo3.addRow(listaT.get(i).arreglo());
            }
        }
        
        else if (e.getSource() == frm.mostrarBtn) {
            int fila = frm.tablaTaxonomias2.getSelectedRow();
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
            
            mod.setEspecie(frm.tablaTaxonomias2.getValueAt(fila, 0).toString());
            modT.buscar(mod);
            
            fv.especieTF.setText(mod.getEspecie());
            fv.reinoTF.setText(mod.getReino());
            fv.ordenTF.setText(mod.getOrden());
            fv.dominioTF.setText(mod.getDominio());
            fv.familiaTF.setText(mod.getFamilia());
            fv.claseTF.setText(mod.getClase());
            fv.filoTF.setText(mod.getFilo());
            fv.generoTF.setText(mod.getGenero());
            fv.alturaTF.setText(Double.toString(mod.getAltura()));
            fv.largoTF.setText(Double.toString(mod.getLargo()));
            fv.pesoTF.setText(Double.toString(mod.getPeso()));
            fv.alimentacionTF.setText(mod.getAlimentacion());
            fv.registradoTF.setText(mod.getRegistrado());
            fv.paleantologoTF.setText(mod.getPaleantologo());
            
            fv.setVisible(true);
            frm.setVisible(false);
            
            fv.tablaTiempos.setModel(modelo);

            modelo.addColumn("Periodo");
            modelo.addColumn("Era");
            modelo.addColumn("Epoca");
            modelo.addColumn("Descubierto");
            
            listaT = modC.buscarTiemposFull(mod.getEspecie());

            for (int i = 0; i < listaT.size(); i++) {
                modelo.addRow(listaT.get(i).arreglo());
            }
            
            fv.tablaPaises.setModel(modelo2);

            modelo2.addColumn("Pais");
            modelo2.addColumn("Continente");
            modelo2.addColumn("Extension");
            
            listaT1 = modC.buscarPaisesFull(mod.getEspecie());

            for (int i = 0; i < listaT1.size(); i++) {
                modelo2.addRow(listaT1.get(i).arreglo());
            }
        } 
//         
        else if (fv.regresarBtn == e.getSource()) {
            fv.setVisible(false);
            frm.setVisible(true);
            cargarTabla();
        } 
//        
        else if (e.getSource() == frm.buscarBtn) {
            
            listaRV.clear();
            limpiarTabla();
            modC.coincidencias(listaRV, frm.buscarTF.getText());
            
            if (listaRV.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();
        } 
  
    }
    

    
    public void cargarTabla(){
       modelo = new DefaultTableModel();
       frm.tablaTaxonomias2.setModel(modelo);

       modelo.addColumn("Especie");
       modelo.addColumn("Registrado Por:");
       modelo.addColumn("Paleontologo");
       modelo.addColumn("Tiempos");
       modelo.addColumn("Paises");

       Object[] fila = new Object[5];

       for(int i=0; i<listaRV.size(); i++){
           fila = listaRV.get(i).arreglo();
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
   
}
