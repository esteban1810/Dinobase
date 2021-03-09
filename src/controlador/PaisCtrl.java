package controlador;

import controlador.ClimaCtrl;
import view.pais.PaisForm;
import view.pais.PaisIndex;
import view.clima.ClimaIndex;
import view.clima.ClimaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasPais;
import modelo.Pais;
import modelo.Clima;
import modelo.ConsultasClima;
import modelo.ConsultasPais_Clima;



public class PaisCtrl implements ActionListener{
    private Pais mod;
    private ConsultasPais modC;
    private PaisForm frame;
    private PaisIndex frameAux;
    private ClimaIndex modClim;
    private DefaultListModel modeloList;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Pais> lista;
    private MenuCtrl ctrlM;
    
    
    
     public PaisCtrl(Pais mod, ConsultasPais modC){
        ctrlM = new MenuCtrl();
        this.mod=mod;
        this.modC=modC;  
        this.modClim = new ClimaIndex();
        this.frame=new PaisForm();
        this.frameAux= new PaisIndex();
        
        lista = new ArrayList();
                
        this.frame.btnGuardar.addActionListener(this); 
        this.frame.btnModificar.addActionListener(this);
        this.frame.btnEliminar.addActionListener(this);
        this.frame.regresarBtn.addActionListener(this);
        this.frame.btnAgreClim.addActionListener(this);
        
                     
        this.frameAux.buscarBtn.addActionListener(this); 
        this.frameAux.todoBtn.addActionListener(this);
        this.frameAux.mostrarBtn.addActionListener(this);
        this.frameAux.nuevoBtn.addActionListener(this);
        this.frameAux.regresarBtn.addActionListener(this);
        this.frameAux.agregarBtn.addActionListener(this);
        this.frameAux.aceptarBtn.addActionListener(this);
        
        this.frameAux.aceptarBtn.setVisible(false);
        this.frameAux.agregarBtn.setVisible(false);
        this.frameAux.listaPaises.setVisible(false);
       
        modC.todosPaises(lista);
        cargarTabla();
        
    }
     
     public void cargarTabla(){
        model = new DefaultTableModel();
        
        frameAux.tbPais.setModel(model);
        model.addColumn("Nombre");
        model.addColumn("Continente");
        model.addColumn("Extension");

        Object[] fila = new Object[3];

        for(int i=0; i<lista.size(); i++){
            System.out.println(i+" : Fila");
            fila = lista.get(i).arreglo();
            model.addRow(fila);
        }
    }
     
    public PaisCtrl(Pais mod, ConsultasPais modC,DefaultListModel modeloList){
        this(mod,modC);
        this.modeloList=modeloList;
        this.frameAux.listaPaises.setModel(modeloList);
        this.frameAux.aceptarBtn.setVisible(true);
        this.frameAux.agregarBtn.setVisible(true);
        this.frameAux.listaPaises.setVisible(true);
    }
     
    public void limpiar(){
        frame.txtNombre.setText(null);
        frame.txtConti.setText(null);
        frame.txtExten.setText(null);         
    } 
    
    
     public void iniciar(){
        frame.setTitle("Paises");
        frame.setLocationRelativeTo(null);
        frameAux.setTitle("TablaPaises");
        frameAux.setLocationRelativeTo(null);
        frameAux.setVisible(true);     
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        DefaultListModel modelo;
        
        if(e.getSource() == frameAux.nuevoBtn){
            DefaultListModel dlm = new DefaultListModel();
            this.frame.ListPaisClima.setModel(dlm);
            frame.setVisible(true);
            frameAux.setVisible(false);
            frame.btnModificar.setVisible(false);
            frame.btnEliminar.setVisible(false);
        }

        else if(e.getSource() == frame.btnGuardar){
            
            ConsultasPais_Clima pc = new ConsultasPais_Clima();
            DefaultListModel dlm;
            
            mod.setNombre(frame.txtNombre.getText());
            mod.setContinente(frame.txtConti.getText());
            mod.setExtension(Float.parseFloat(frame.txtExten.getText()));
                      
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                return;
            }            
            dlm = (DefaultListModel) this.frame.ListPaisClima.getModel();

            pc.registrar(mod.getNombre(), dlm.toArray());

            limpiar();
            frame.setVisible(false);
            frameAux.setVisible(true);
        }
        
        else if(e.getSource() == frame.btnModificar){
            String nombre = mod.getNombre();
            ConsultasPais_Clima pc = new ConsultasPais_Clima();
            mod.setNombre(frame.txtNombre.getText());
            mod.setContinente(frame.txtConti.getText());
            mod.setExtension(Float.parseFloat(frame.txtExten.getText()));
            
            
            if(modC.modificar(mod, nombre)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            
            ArrayList<String> listaClimas = new ArrayList();
            
            for(int i = 0; i< this.frame.ListPaisClima.getModel().getSize();i++){
               listaClimas.add(frame.ListPaisClima.getModel().getElementAt(i));
            }
            
            pc.modificar(mod.getNombre(), listaClimas.toArray());
            
            limpiar();
            modC.todosPaises(lista);
            cargarTabla();
            frame.setVisible(false);
            frameAux.setVisible(true);
        }
        
        else if(e.getSource() == frame.btnEliminar){
            mod.setNombre(frame.txtNombre.getText());
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            limpiar();
            frame.setVisible(false);
            frameAux.setVisible(true);
        }
        
        else if(e.getSource() == frameAux.buscarBtn){
            lista.clear();
            int fila2 = frameAux.tbPais.getRowCount();
                    for(int i = fila2-1; i >= 0 ; i--){
                        model.removeRow(i); 
                    }
            modC.coincidencias(lista, frameAux.buscarTF.getText());
            if(lista.size()==0){
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();            

        }
        
        else if(e.getSource() == frameAux.todoBtn){  
            modC.todosPaises(lista);          
            cargarTabla();
        }
        
        else if (e.getSource() == frameAux.mostrarBtn){
            frame.btnGuardar.setVisible(false);
            int fila= frameAux.tbPais.getSelectedRow();
            ArrayList<String> climas;
            String pais;
            DefaultListModel modelClima;
            
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            pais = frameAux.tbPais.getValueAt(fila,0).toString();
            climas = new ConsultasPais_Clima().getRelacionesClima(pais);
            modelClima = new DefaultListModel();
            for(int i=0; i<climas.size(); i++){
                modelClima.addElement(climas.get(i));
            }
            frame.ListPaisClima.setModel(modelClima);
            
            mod = modC.buscar(pais);
            
            frame.txtNombre.setText(mod.getNombre());
            frame.txtConti.setText(mod.getContinente());
            frame.txtExten.setText(String.valueOf(mod.getExtension()));

            frame.setVisible(true);
            frameAux.setVisible(false);
           
        }
        
        else if(e.getSource() == frame.regresarBtn){
            frame.setVisible(false);
            frameAux.setVisible(true);
        }
        
        else if(e.getSource() == frameAux.regresarBtn){
            frameAux.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
        }
        else if (e.getSource() == frame.btnAgreClim){
            ClimaCtrl ctrlClima = new ClimaCtrl(new Clima(), new ConsultasClima(), (DefaultListModel)this.frame.ListPaisClima.getModel());
            ctrlClima.iniciar();
        }
        
        else if(e.getSource()==this.frameAux.agregarBtn){
            int fila = this.frameAux.tbPais.getSelectedRow();
            String tiempo;
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            tiempo = frameAux.tbPais.getValueAt(fila, 0).toString();
            
            if(!this.modeloList.removeElement(tiempo)){
                this.modeloList.addElement(tiempo);
            }
        }
        
        else if(e.getSource()==this.frameAux.aceptarBtn){
            this.frameAux.setVisible(false);
        }
        
    }

}
