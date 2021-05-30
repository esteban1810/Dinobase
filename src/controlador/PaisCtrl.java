package controlador;

import view.pais.PaisForm;
import view.pais.PaisIndex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasPais;
import clase.Pais;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasPais_Clima;



public class PaisCtrl implements ActionListener, MouseListener, KeyListener, ItemListener{
    private Pais pais;
    private ConsultasPais paisModelo;
    private PaisForm paisForm;
    private PaisIndex paisIndex;
    
    private DefaultListModel modeloList;
    DefaultTableModel model;
    ArrayList<Pais> lista;
    private MenuCtrl menuCtrl;
    
    private int tipo;
    
    
    
     public PaisCtrl(){
        menuCtrl    = new MenuCtrl();
        pais        = new Pais();
        paisModelo  = new ConsultasPais();
        paisForm    = new PaisForm();
        paisIndex   = new PaisIndex();
        model       = new DefaultTableModel();
        lista       = new ArrayList();
                
        actionListener();
        
       
        paisModelo.todosPaises(lista);
        cargarTabla();
        
    }

     public void actionListener(){
         this.paisForm.btnGuardar.addActionListener(this); 
        this.paisForm.btnModificar.addActionListener(this);
        this.paisForm.btnEliminar.addActionListener(this);
        this.paisForm.regresarBtn.addActionListener(this);
        this.paisForm.btnAgreClim.addActionListener(this);
        
        this.paisIndex.todoBtn.addActionListener(this);
        this.paisIndex.nuevoBtn.addActionListener(this);
        this.paisIndex.regresarBtn.addActionListener(this);
        this.paisIndex.aceptarBtn.addActionListener(this);
        
        this.paisIndex.aceptarBtn.setVisible(false);
        this.paisIndex.listaPaises.setVisible(false);
        
        this.paisIndex.continenteCB.addItemListener(this);
        this.paisIndex.tbPais.addMouseListener(this);
        this.paisIndex.buscarTF.addKeyListener(this);
     }
     
     
     public void cargarTabla(){
        model = new DefaultTableModel();
        
        paisIndex.tbPais.setModel(model);
        model.addColumn("Nombre");
        model.addColumn("Continente");
        model.addColumn("Extension");

        Object[] fila = new Object[3];

        for(int i=0; i<lista.size(); i++){
            fila = lista.get(i).arreglo();
            model.addRow(fila);
        }
    }
     
    public PaisCtrl(DefaultListModel modeloList){
        this();
        this.modeloList=modeloList;
        this.paisIndex.listaPaises.setModel(modeloList);
        this.paisIndex.aceptarBtn.setVisible(true);
        this.paisIndex.listaPaises.setVisible(true);
    }
     
    public void limpiar(){
        paisForm.txtNombre.setText(null);
        paisForm.txtConti.setText(null);
        paisForm.txtExten.setText(null);         
    } 
    
    
     public void iniciar(){
        paisForm.setTitle("Paises");
        paisForm.setLocationRelativeTo(null);
        paisIndex.setTitle("TablaPaises");
        paisIndex.setLocationRelativeTo(null);
        paisIndex.setVisible(true);     
        
    }
     
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paisIndex.nuevoBtn){
            presionarNuevoBtn();
        }

        else if(e.getSource() == paisForm.btnGuardar){
            presionarBtnGuardar();
        }
        
        else if(e.getSource() == paisForm.btnModificar){
            presionarBtnModificar();
        }
        
        else if(e.getSource() == paisForm.btnEliminar){
            presionarBtnEliminar();
        }
        
        
        else if(e.getSource() == paisIndex.todoBtn){  
            this.paisIndex.buscarTF.setText(null);
            this.paisIndex.continenteCB.setSelectedIndex(0);
            paisModelo.todosPaises(lista);
            cargarTabla();
        }
        
        else if(e.getSource() == paisForm.regresarBtn){
            paisForm.setVisible(false);
            paisIndex.setVisible(true);
        }
        
        else if(e.getSource() == paisIndex.regresarBtn){
            paisIndex.setVisible(false);
            menuCtrl.iniciar();
            menuCtrl.desbloquear(menuCtrl.getNickname());
            menuCtrl.administrador();
        }
        else if (e.getSource() == paisForm.btnAgreClim){
            ClimaCtrl ctrlClima = new ClimaCtrl((DefaultListModel)this.paisForm.ListPaisClima.getModel());
            ctrlClima.iniciar();
            ctrlClima.likeRelacion();
        }
        
        else if(e.getSource()==this.paisIndex.aceptarBtn){
            this.paisIndex.setVisible(false);
        }
        
    }

    private void presionarNuevoBtn() {
        DefaultListModel dlm = new DefaultListModel();
        this.paisForm.ListPaisClima.setModel(dlm);
        paisForm.setVisible(true);
        paisIndex.setVisible(false);
        paisForm.btnModificar.setVisible(false);
        paisForm.btnEliminar.setVisible(false);
    }

    private void presionarBtnGuardar() {
        ConsultasPais_Clima pc = new ConsultasPais_Clima();
        DefaultListModel dlm;
        
        pais.setNombre(paisForm.txtNombre.getText());
        pais.setContinente(paisForm.txtConti.getText());
        pais.setExtension(Float.parseFloat(paisForm.txtExten.getText()));
                    
        if(paisModelo.registrar(pais)){
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
            return;
        }            
        dlm = (DefaultListModel) this.paisForm.ListPaisClima.getModel();

        pc.registrar(pais.getNombre(), dlm.toArray());

        limpiar();
        paisForm.setVisible(false);
        paisIndex.setVisible(true);
    }

    private void presionarBtnModificar() {
            String nombre = pais.getNombre();
            ConsultasPais_Clima pc = new ConsultasPais_Clima();
            pais.setNombre(paisForm.txtNombre.getText());
            pais.setContinente(paisForm.txtConti.getText());
            pais.setExtension(Float.parseFloat(paisForm.txtExten.getText()));
            
            
            if(paisModelo.modificar(pais, nombre)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            
            ArrayList<String> listaClimas = new ArrayList();
            
            for(int i = 0; i< this.paisForm.ListPaisClima.getModel().getSize();i++){
               listaClimas.add(paisForm.ListPaisClima.getModel().getElementAt(i));
            }
            
            pc.modificar(pais.getNombre(), listaClimas.toArray());
            
            limpiar();
            paisModelo.todosPaises(lista);
            cargarTabla();
            paisForm.setVisible(false);
            paisIndex.setVisible(true);
    }

    private void presionarBtnEliminar() {
        pais.setNombre(paisForm.txtNombre.getText());
        
        if(paisModelo.eliminar(pais)){
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        limpiar();
        paisForm.setVisible(false);
        paisIndex.setVisible(true);
    }

    private void presionarBuscarBtn() {
        String pais = paisIndex.buscarTF.getText();
        String continente = this.paisIndex.continenteCB.getSelectedItem().toString();
        int fila2 = paisIndex.tbPais.getRowCount();
        
        continente= (continente.equals("-- Seleccionar --"))?"":continente;
        
        lista.clear();
        
        if(continente.isEmpty()){
            if(pais.isEmpty()){
                paisModelo.todosPaises(lista);     
                cargarTabla();
                return;
            }
        }
        
        for(int i = fila2-1; i >= 0 ; i--){
            model.removeRow(i); 
        }
        
        
        lista = paisModelo.coincidencias(pais,continente);
        
        if(lista.size()==0){
            return;
        }
        cargarTabla();            
    }
    

    private void presionarMostrarBtn() {
        paisForm.btnGuardar.setVisible(false);
        int fila= paisIndex.tbPais.getSelectedRow();
        ArrayList<String> climas;
        String nombrePais;
        DefaultListModel modelClima;
        
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        
        nombrePais = paisIndex.tbPais.getValueAt(fila,0).toString();
        climas = new ConsultasPais_Clima().getRelacionesClima(nombrePais);
        modelClima = new DefaultListModel();
        for(int i=0; i<climas.size(); i++){
            modelClima.addElement(climas.get(i));
        }
        paisForm.ListPaisClima.setModel(modelClima);
        
        pais = paisModelo.buscar(nombrePais);
        
        paisForm.txtNombre.setText(pais.getNombre());
        paisForm.txtConti.setText(pais.getContinente());
        paisForm.txtExten.setText(String.valueOf(pais.getExtension()));

        paisForm.setVisible(true);
        paisIndex.setVisible(false);
    }

    private void presionarAgregarBtn() {
        int fila = this.paisIndex.tbPais.getSelectedRow();
        String tiempo;
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        
        tiempo = paisIndex.tbPais.getValueAt(fila, 0).toString();
        
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
            if(me.getSource()==this.paisIndex.tbPais){
                this.presionarMostrarBtn();
            } 
        } else 
        if(tipo==2){
            if(me.getSource()==this.paisIndex.tbPais){
                this.presionarAgregarBtn();
            } 
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me){}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {
//        if(ke.getSource()==this.paisIndex.buscarTF){
//            presionarBuscarBtn();
//        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource()==this.paisIndex.buscarTF){
            presionarBuscarBtn();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==this.paisIndex.continenteCB){
            presionarBuscarBtn();
        }
    }
    
}
