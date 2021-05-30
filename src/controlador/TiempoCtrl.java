package controlador;

import clase.Tiempo;
import view.tiempo.TiempoIndex;
import view.tiempo.TiempoForm;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.*;

public class TiempoCtrl implements ActionListener, ChangeListener, MouseListener, KeyListener{
    private Tiempo tiempo;
    private ConsultasTiempo tiempoModelo;
    private TiempoIndex tiempoIndex;
    private TiempoForm tiempoForm;
    
    private DefaultTableModel modelo;
    private ArrayList<Tiempo> lista;
    private MenuCtrl ctrlM;
    private DefaultListModel modeloList;
    
    private int tipo;
    
    public TiempoCtrl(){
        this.tiempo= new Tiempo();
        this.tiempoModelo= new ConsultasTiempo();
        
        this.tiempoIndex=new TiempoIndex();
        tiempoForm = new TiempoForm();
        modelo = new DefaultTableModel();
        lista = new ArrayList();
        ctrlM = new MenuCtrl();
        
        cargarSpinners();
        
        tiempoModelo.todosTiempos(lista);
        cargarTabla();
        
        actionListener();
    }
    
    public void actionListener(){
        this.tiempoIndex.nuevoBtn.addActionListener(this);
        this.tiempoIndex.todoBtn.addActionListener(this);
        this.tiempoIndex.aceptarBtn.addActionListener(this);
        this.tiempoIndex.setLocationRelativeTo(null);
        this.tiempoIndex.listaT.setVisible(false);
        this.tiempoIndex.aceptarBtn.setVisible(false);
        this.tiempoIndex.regresarBtn.addActionListener(this);
        
        this.tiempoForm.registrarBtn.addActionListener(this);
        this.tiempoForm.eliminarBtn.addActionListener(this);
        this.tiempoForm.limpiarBtn.addActionListener(this);
        this.tiempoForm.modificarBtn.addActionListener(this);
        this.tiempoForm.regresarBtn.addActionListener(this);
        this.tiempoForm.setLocationRelativeTo(null);
        
        this.tiempoIndex.tablaTiempos.addMouseListener(this);
        this.tiempoIndex.buscarTF.addKeyListener(this);
        
        this.tiempoIndex.sprDesde.addChangeListener(this);
        this.tiempoIndex.sprHasta.addChangeListener(this);
    }
    
    public void cargarSpinners(){
        int desde = Integer.parseInt(tiempoModelo.getMenorAnio());
        int hasta = Integer.parseInt(tiempoModelo.getMayorAnio());
        this.tiempoIndex.sprDesde.setValue(desde);
        this.tiempoIndex.sprHasta.setValue(hasta);
    }
    
    public TiempoCtrl(DefaultListModel modeloList){
        this();
        this.modeloList=modeloList;
        this.tiempoIndex.listaT.setModel(modeloList);
        this.tiempoIndex.listaT.setVisible(true);
        this.tiempoIndex.aceptarBtn.setVisible(true);
    }
    
    public void iniciar(){
        tiempoIndex.setVisible(true);
        tiempoIndex.setTitle("Tiempo");
        tiempoIndex.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tiempoForm.registrarBtn){
            presionarRegistrarBtn();
        } 
        
        else if (e.getSource() == tiempoIndex.todoBtn) {
            tiempoModelo.todosTiempos(lista);
            tiempoIndex.buscarTF.setText("");
            this.cargarSpinners();
            cargarTabla();
        } 
        
        
        else if (e.getSource() == tiempoForm.modificarBtn) {
            presionarModificarBtn();
        } 
        
        else if (e.getSource() == tiempoForm.eliminarBtn) {
            presionarEliminarBtn();
        } 
        
        else if (e.getSource() == tiempoIndex.nuevoBtn) {
            presionarNuevoBtn();
        } 
        
        else if (tiempoForm.regresarBtn == e.getSource()) {
            presionarRegresarBtn();
        } 
        
        else if (e.getSource() == tiempoIndex.aceptarBtn) {
            tiempoIndex.setVisible(false);
        } 
        
        else if (e.getSource() == tiempoForm.limpiarBtn) {
            limpiar();
        }
        else if (e.getSource() == tiempoIndex.regresarBtn){
            tiempoIndex.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
            ctrlM.administrador();
        }
    }
    
    public void limpiar(){
        tiempoForm.periodoTF.setText(null);
        tiempoForm.eraTF.setText(null);
        tiempoForm.epocaTF.setText(null);
        tiempoForm.descubrimientoTF.setText(null);
    }
    
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        tiempoIndex.tablaTiempos.setModel(modelo);

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
        if(!this.tiempoForm.periodoTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Periodo, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.tiempoForm.eraTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar era, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.tiempoForm.epocaTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Epoca, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.tiempoForm.descubrimientoTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Descubierto, inténtelo de nuevo.");
            return false;
        }

        return true;
    }

    private void presionarRegistrarBtn() {
        tiempo.setPeriodo(tiempoForm.periodoTF.getText());
        tiempo.setEra(tiempoForm.eraTF.getText());
        tiempo.setEpoca(tiempoForm.epocaTF.getText());
        tiempo.setDescubierto(tiempoForm.descubrimientoTF.getText());
        if (tiempoModelo.registrar(tiempo)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        limpiar();
    }

    private void presionarMostrarBtn() {
        int fila = tiempoIndex.tablaTiempos.getSelectedRow();
        this.tiempoForm.registrarBtn.setVisible(false);
        this.tiempoForm.modificarBtn.setVisible(true);
        this.tiempoForm.eliminarBtn.setVisible(true);
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        tiempo.setPeriodo(tiempoIndex.tablaTiempos.getValueAt(fila, 0).toString());
        tiempoModelo.buscar(tiempo);
        tiempoForm.setVisible(true);
        tiempoIndex.setVisible(false);
        tiempoForm.periodoTF.setText(tiempo.getPeriodo());
        tiempoForm.eraTF.setText(tiempo.getEra());
        tiempoForm.epocaTF.setText(tiempo.getEpoca());
        tiempoForm.descubrimientoTF.setText(tiempo.getDescubierto());
    }

    private void presionarModificarBtn() {
        String nombreTiempo = tiempo.getPeriodo();
        tiempo.setPeriodo(tiempoForm.periodoTF.getText());
        tiempo.setEra(tiempoForm.eraTF.getText());
        System.out.println(tiempo.getPeriodo());
        tiempo.setEpoca(tiempoForm.epocaTF.getText());
        tiempo.setDescubierto(tiempoForm.descubrimientoTF.getText());

        if (tiempoModelo.modificar(tiempo, nombreTiempo)) {
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        tiempoForm.setVisible(false);
        tiempoIndex.setVisible(true);
        tiempoForm.setVisible(false);
        limpiarTabla();
        tiempoModelo.todosTiempos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarEliminarBtn() {
        tiempo.setPeriodo(tiempoForm.periodoTF.getText());

        if (tiempoModelo.eliminar(tiempo)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        tiempoForm.setVisible(false);
        tiempoIndex.setVisible(true);
        tiempoForm.setVisible(false);
        limpiarTabla();
        tiempoModelo.todosTiempos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarNuevoBtn() {
        tiempoIndex.setVisible(false);
        tiempoForm.setVisible(true);
        tiempoForm.eliminarBtn.setVisible(false);
        tiempoForm.modificarBtn.setVisible(false);
        tiempoForm.registrarBtn.setVisible(true);
    }

    private void presionarRegresarBtn() {
        tiempoForm.setVisible(false);
        tiempoIndex.setVisible(true);
        tiempoForm.setVisible(false);
        limpiarTabla();
        tiempoModelo.todosTiempos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarBuscarBtn() {
        String periodo = tiempoIndex.buscarTF.getText();
        String desde = tiempoIndex.sprDesde.getValue().toString();
        String hasta = tiempoIndex.sprHasta.getValue().toString();
        
        
        limpiarTabla();
        
        lista = tiempoModelo.coincidencias(periodo,desde,hasta);

        
        if (lista.isEmpty()) {
            return;
        }
        
        cargarTabla();
    }

    private void presionarAgregarBtn() {
        int fila = tiempoIndex.tablaTiempos.getSelectedRow();
        String tiempo;
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        
        tiempo = tiempoIndex.tablaTiempos.getValueAt(fila, 0).toString();
        
        if(!this.modeloList.removeElement(tiempo)){
            this.modeloList.addElement(tiempo);
        }
    }
    
    public void likeVisita(){
        tipo = 1;
    }
    
    public void likeRelacion(){
        tipo = 2;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(tipo==1){
            if(me.getSource()==this.tiempoIndex.tablaTiempos){
                this.presionarMostrarBtn();
            } 
        } else 
        if(tipo==2){
            if(me.getSource()==this.tiempoIndex.tablaTiempos){
                presionarAgregarBtn();
            } 
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==this.tiempoIndex.sprDesde){
            presionarBuscarBtn();
        } else 
        if(ke.getSource()==this.tiempoIndex.sprHasta){
            presionarBuscarBtn();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource()==this.tiempoIndex.buscarTF){
            presionarBuscarBtn();
        } 
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        System.out.println("Aqui andamos");
        if(ce.getSource()==this.tiempoIndex.sprDesde){
            presionarBuscarBtn();
        } else 
        if(ce.getSource()==this.tiempoIndex.sprHasta){
            presionarBuscarBtn();
        }
    }
}