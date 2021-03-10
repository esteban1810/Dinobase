package controlador;

import clase.Tiempo;
import view.tiempo.TiempoIndex;
import view.tiempo.TiempoForm;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;

public class TiempoCtrl implements ActionListener{
    private Tiempo mod;
    private ConsultasTiempo modC;
    private TiempoIndex frm;
    private TiempoForm frmReg;
    private static DefaultListModel listaR;
    private DefaultTableModel modelo;
    private ArrayList<Tiempo> lista;
    private MenuCtrl ctrlM;
    private DefaultListModel modeloList;
    
    public TiempoCtrl(Tiempo mod, ConsultasTiempo modC){
        this.mod=mod;
        this.modC=modC;
        
        this.frm=new TiempoIndex();
        frmReg = new TiempoForm();
        modelo = new DefaultTableModel();
        listaR = new DefaultListModel();
        lista = new ArrayList();
        ctrlM = new MenuCtrl();
        
        this.frm.buscarBtn.addActionListener(this);
        this.frm.mostrarBtn.addActionListener(this);
        this.frm.nuevoBtn.addActionListener(this);
        this.frm.todoBtn.addActionListener(this);
        this.frm.agregarBtn.addActionListener(this);
        this.frm.aceptarBtn.addActionListener(this);
        this.frm.setLocationRelativeTo(null);
        this.frm.listaT.setVisible(false);
        this.frm.aceptarBtn.setVisible(false);
        this.frm.agregarBtn.setVisible(false);
        this.frm.regresarBtn.addActionListener(this);
        
        this.frmReg.registrarBtn.addActionListener(this);
        this.frmReg.eliminarBtn.addActionListener(this);
        this.frmReg.limpiarBtn.addActionListener(this);
        this.frmReg.modificarBtn.addActionListener(this);
        this.frmReg.regresarBtn.addActionListener(this);
        this.frmReg.setLocationRelativeTo(null);
        
        
        modC.todosTiempos(lista);
        cargarTabla();
    }
    
    public TiempoCtrl(Tiempo mod, ConsultasTiempo modC,DefaultListModel modeloList){
        this(mod,modC);
        this.modeloList=modeloList;
        this.frm.listaT.setModel(modeloList);
        this.frm.listaT.setVisible(true);
        this.frm.aceptarBtn.setVisible(true);
        this.frm.agregarBtn.setVisible(true);
    }
    
    public static DefaultListModel getListaR(){
        return listaR;
    }
    
    public void iniciar(){
        frm.setVisible(true);
        frm.setTitle("Tiempo");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource() == frmReg.registrarBtn){
            mod.setPeriodo(frmReg.periodoTF.getText());
            mod.setEra(frmReg.eraTF.getText());
            mod.setEpoca(frmReg.epocaTF.getText());
            mod.setDescubierto(frmReg.descubrimientoTF.getText());
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
        } 
        
        else if (e.getSource() == frm.todoBtn) {
            modC.todosTiempos(lista);
            cargarTabla();
        } 
        
        else if (e.getSource() == frm.mostrarBtn) {
            int fila = frm.tablaTiempos.getSelectedRow();
            this.frmReg.registrarBtn.setVisible(false);
            this.frmReg.modificarBtn.setVisible(true);
            this.frmReg.eliminarBtn.setVisible(true);
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            mod.setPeriodo(frm.tablaTiempos.getValueAt(fila, 0).toString());
            modC.buscar(mod);
            frmReg.setVisible(true);
            frm.setVisible(false);
            frmReg.periodoTF.setText(mod.getPeriodo());
            frmReg.eraTF.setText(mod.getEra());
            frmReg.epocaTF.setText(mod.getEpoca());
            frmReg.descubrimientoTF.setText(mod.getDescubierto());
        } 
        
        else if (e.getSource() == frmReg.modificarBtn) {
            String tiempo = mod.getPeriodo();
            mod.setPeriodo(frmReg.periodoTF.getText());
            mod.setEra(frmReg.eraTF.getText());
            System.out.println(mod.getPeriodo());
            mod.setEpoca(frmReg.epocaTF.getText());
            mod.setDescubierto(frmReg.descubrimientoTF.getText());

            if (modC.modificar(mod, tiempo)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosTiempos(lista);
            cargarTabla();
            limpiar();
        } 
        
        else if (e.getSource() == frmReg.eliminarBtn) {
            mod.setPeriodo(frmReg.periodoTF.getText());

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosTiempos(lista);
            cargarTabla();
            limpiar();
        } 
        
        else if (e.getSource() == frm.nuevoBtn) {
            frm.setVisible(false);
            frmReg.setVisible(true);
            frmReg.eliminarBtn.setVisible(false);
            frmReg.modificarBtn.setVisible(false);
            frmReg.registrarBtn.setVisible(true);
//            limpiar();
        } 
        
        else if (frmReg.regresarBtn == e.getSource()) {
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosTiempos(lista);
            cargarTabla();
            limpiar();
        } 
        
        else if (e.getSource() == frm.buscarBtn) {
            lista.clear();
            limpiarTabla();
            modC.coincidencias(lista, frm.buscarTF.getText());
            
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();
        } 
        
        else if (e.getSource() == frm.agregarBtn) {
            int fila = frm.tablaTiempos.getSelectedRow();
            String tiempo;
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            tiempo = frm.tablaTiempos.getValueAt(fila, 0).toString();
            
            if(!this.modeloList.removeElement(tiempo)){
                this.modeloList.addElement(tiempo);
            }
            
            listaR.addElement(tiempo);
        } 
        
        else if (e.getSource() == frm.aceptarBtn) {
            frm.setVisible(false);
        } 
        
        else if (e.getSource() == frmReg.limpiarBtn) {
            limpiar();
        }
        else if (e.getSource() == frm.regresarBtn){
            frm.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
        }
    }
    
    public void limpiar(){
        frmReg.periodoTF.setText(null);
        frmReg.eraTF.setText(null);
        frmReg.epocaTF.setText(null);
        frmReg.descubrimientoTF.setText(null);
    }
    
    public void cargarTabla(){
       modelo = new DefaultTableModel();
       frm.tablaTiempos.setModel(modelo);

       modelo.addColumn("Perido");
       modelo.addColumn("Era");
       modelo.addColumn("Epoca");
       modelo.addColumn("Descubierto");

       Object[] fila = new Object[14];

       for(int i=0; i<lista.size(); i++){
           fila = lista.get(i).arreglo();
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
        public boolean validaciones() {
        if(!this.frmReg.periodoTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Periodo, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.frmReg.eraTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar era, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.frmReg.epocaTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Epoca, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.frmReg.descubrimientoTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Descubierto, inténtelo de nuevo.");
            return false;
        }

        return true;
    }
}