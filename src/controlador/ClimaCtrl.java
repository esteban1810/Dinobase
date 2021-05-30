package controlador;

import view.clima.ClimaForm;
import view.clima.ClimaIndex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasClima;
import clase.Clima;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClimaCtrl  implements ActionListener, MouseListener, KeyListener{
    private Clima clima;
    private ConsultasClima climaModelo;
    private MenuCtrl ctrlM;
    private ClimaForm climaForm;
    private ClimaIndex climaIndex;
    
    
    private DefaultTableModel model = new DefaultTableModel();
    
    private ArrayList<Clima> lista;
    private DefaultListModel modeloList;
    private int tipo;
    
    public ClimaCtrl(){
        lista = new ArrayList();
        this.clima=new Clima();
        this.climaModelo=new ConsultasClima();
        this.climaForm=new ClimaForm();
        this.climaIndex=new ClimaIndex();
        ctrlM = new MenuCtrl();
       
        actionListener();
        
        
        cargarTabla();
    }
    
    public void actionListener(){
        this.climaIndex.todoBtn.addActionListener(this);
        this.climaIndex.nuevoBtn.addActionListener(this);
        this.climaIndex.regresarBtn.addActionListener(this);
        this.climaIndex.btnAceptar.addActionListener(this);
        
        this.climaIndex.listClima.setVisible(false);
        this.climaIndex.btnAceptar.setVisible(false);
        
        this.climaForm.btnGuardar.addActionListener(this);                
        this.climaForm.btnEliminar.addActionListener(this);
        this.climaForm.btnModificar.addActionListener(this);
        this.climaForm.regresarBtn.addActionListener(this);
        
        this.climaIndex.tbClima.addMouseListener(this);
        this.climaIndex.buscarTF.addKeyListener(this);
        
    }
    
    public ClimaCtrl(DefaultListModel modeloList){
        this();
        this.modeloList=modeloList;
        this.climaIndex.listClima.setModel(modeloList);
        this.climaIndex.listClima.setVisible(true);
        this.climaIndex.btnAceptar.setVisible(true);
    }
     
    public void cargarTabla(){
        model = new DefaultTableModel();
        this.climaIndex.tbClima.setModel(model);
        
        model.addColumn("Nombre");
        model.addColumn("Humedad");
        model.addColumn("Presion");
        model.addColumn("Temperatura");
        
        Object[] fila = new Object[4];

        for(int i=0; i<lista.size(); i++){
            fila = lista.get(i).arreglo();
            model.addRow(fila);
        }
    }
    
    public void limpiar(){
        climaForm.txtNombre.setText(null);
        climaForm.txtHumedad.setText(null);
        climaForm.txtPresion.setText(null);
        climaForm.txtTemp.setText(null);
    }
    
     public void iniciar(){
        climaForm.setTitle("Climas");
        climaForm.setLocationRelativeTo(null);
        climaIndex.setTitle("TablaClimas");
        climaIndex.setLocationRelativeTo(null);
        climaIndex.setVisible(true);
        climaModelo.todosClimas(lista); 
        cargarTabla();
    }
     
    public void selectNuevoBtn(){
       climaForm.btnGuardar.setVisible(true);
       climaForm.btnEliminar.setVisible(false);
       climaForm.btnModificar.setVisible(false);
       climaForm.setVisible(true);
       climaIndex.setVisible(false);
    }
    
    public void selectBtnGuardar(){
        clima.setNombre(climaForm.txtNombre.getText());
        clima.setHumedad(Integer.parseInt(climaForm.txtHumedad.getText()));
        clima.setPresion(Float.parseFloat(climaForm.txtPresion.getText()));
        clima.setTemperatura(Float.parseFloat(climaForm.txtTemp.getText()));

        if(climaModelo.registrar(clima)){
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        limpiar();
        climaForm.setVisible(false);
        climaIndex.setVisible(true);
    }
     
    public void selectBtnModificar(){
        String nombre = clima.getNombre();

        clima.setNombre(climaForm.txtNombre.getText());
        clima.setHumedad(Integer.parseInt(climaForm.txtHumedad.getText()));
        clima.setPresion(Float.parseFloat(climaForm.txtPresion.getText()));
        clima.setTemperatura(Float.parseFloat(climaForm.txtTemp.getText()));


        if(climaModelo.modificar(clima, nombre)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        limpiar();
        climaForm.setVisible(false);
        climaIndex.setVisible(true);
        climaModelo.todosClimas(lista); 
        cargarTabla();
    }
    
    private void selectBtnEliminar(){
        clima.setNombre(climaForm.txtNombre.getText());
            
        if(climaModelo.eliminar(clima)){
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        limpiar();
        climaForm.setVisible(false);
        climaIndex.setVisible(true);
    }
    
    private void selectBuscarBtn(){
        int fila2 = climaIndex.tbClima.getRowCount();
        for(int i = fila2-1; i >= 0 ; i--){
            model.removeRow(i); 
        }
        climaModelo.coincidencias(lista, climaIndex.buscarTF.getText());
        if(lista.size()==0){
            return;
        }
        cargarTabla();
    }
    
    private void selectMostrarBtn(){
        try{
            int fila= climaIndex.tbClima.getSelectedRow();

            clima.setNombre(climaIndex.tbClima.getValueAt(fila, 0).toString());

            climaForm.txtNombre.setText(climaIndex.tbClima.getValueAt(fila, 0).toString());
            climaForm.txtHumedad.setText(climaIndex.tbClima.getValueAt(fila, 1).toString());
            climaForm.txtPresion.setText(climaIndex.tbClima.getValueAt(fila, 2).toString());
            climaForm.txtTemp.setText(climaIndex.tbClima.getValueAt(fila, 3).toString());


            climaForm.btnGuardar.setVisible(false);
            climaForm.btnEliminar.setVisible(true);
            climaForm.btnModificar.setVisible(true);

            climaForm.setVisible(true);
            climaIndex.setVisible(false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    private void selectBtnAgregar(){
        int fila = climaIndex.tbClima.getSelectedRow(); 
            
        String clima;

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }

        clima = climaIndex.tbClima.getValueAt(fila, 0).toString();

        if(!this.modeloList.removeElement(clima)){
            this.modeloList.addElement(clima);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == climaIndex.nuevoBtn){
            selectNuevoBtn();
        }

        else if(e.getSource() == climaForm.btnGuardar){
            selectBtnGuardar();
        }
        
        else if(e.getSource() == climaForm.btnModificar){
            selectBtnModificar();
        }
        
        else if(e.getSource() == climaForm.btnEliminar){
            selectBtnEliminar();
        }
        
        
        else if(e.getSource() == climaIndex.todoBtn){
           climaModelo.todosClimas(lista); 
           cargarTabla();
        }
        
        else if(e.getSource() == climaForm.regresarBtn){
            climaForm.setVisible(false);
            climaIndex.setVisible(true);
        }
        
        else if(e.getSource() == climaIndex.regresarBtn){
            climaIndex.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
            ctrlM.administrador();
        }
        
        else if (e.getSource() == climaIndex.btnAceptar) {
            climaIndex.setVisible(false);
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
            if(me.getSource()==this.climaIndex.tbClima){
                this.selectMostrarBtn();
            } 
        } else 
        if(tipo==2){
            if(me.getSource()==this.climaIndex.tbClima){
                selectBtnAgregar();
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
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource()==this.climaIndex.buscarTF){
            this.selectBuscarBtn();
        }
    }
}
