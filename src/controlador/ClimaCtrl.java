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


public class ClimaCtrl  implements ActionListener{
    private Clima mod;
    private ConsultasClima modC;
    private ClimaForm frame;
    private MenuCtrl ctrlM;
    private ClimaIndex frameAux;
    DefaultTableModel model = new DefaultTableModel();
    private static DefaultListModel listaR;
    ArrayList<Clima> lista;
    private DefaultListModel modeloList;
    
     public ClimaCtrl(Clima mod, ConsultasClima modC){
        lista = new ArrayList();
        this.mod=mod;
        this.modC=modC;
        this.frame=new ClimaForm();
        this.frameAux=new ClimaIndex();
        listaR = new DefaultListModel();
        ctrlM = new MenuCtrl();
       
        
        this.frameAux.buscarBtn.addActionListener(this);
        this.frameAux.mostrarBtn.addActionListener(this);
        this.frameAux.todoBtn.addActionListener(this);
        this.frameAux.nuevoBtn.addActionListener(this);
        this.frameAux.regresarBtn.addActionListener(this);
        this.frameAux.btnAceptar.addActionListener(this);
        this.frameAux.btnAgregar.addActionListener(this);
        
        this.frameAux.listClima.setVisible(false);
        this.frameAux.btnAgregar.setVisible(false);
        this.frameAux.btnAceptar.setVisible(false);
        
        this.frame.btnGuardar.addActionListener(this);                
        this.frame.btnEliminar.addActionListener(this);
        this.frame.btnModificar.addActionListener(this);
        this.frame.regresarBtn.addActionListener(this);
        
        cargarTabla();
    }
     
     public ClimaCtrl(Clima mod, ConsultasClima modC,DefaultListModel modeloList){
        this(mod,modC);
        this.modeloList=modeloList;
        this.frameAux.listClima.setModel(modeloList);
        this.frameAux.listClima.setVisible(true);
        this.frameAux.btnAceptar.setVisible(true);
        this.frameAux.btnAgregar.setVisible(true);
    }
     
    public void cargarTabla(){
        model = new DefaultTableModel();
        this.frameAux.tbClima.setModel(model);
        
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
        frame.txtNombre.setText(null);
        frame.txtHumedad.setText(null);
        frame.txtPresion.setText(null);
        frame.txtTemp.setText(null);
    }
    
     public void iniciar(){
        frame.setTitle("Climas");
        frame.setLocationRelativeTo(null);
        frameAux.setTitle("TablaClimas");
        frameAux.setLocationRelativeTo(null);
        frameAux.setVisible(true);
        modC.todosClimas(lista); 
        cargarTabla();
    }
    public static DefaultListModel getListaR(){
        return listaR;
    }
     
     @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource() == frameAux.nuevoBtn){
            frame.btnGuardar.setVisible(true);
            frame.btnEliminar.setVisible(false);
            frame.btnModificar.setVisible(false);
            frame.setVisible(true);
            frameAux.setVisible(false);
            
        }

        else if(e.getSource() == frame.btnGuardar){
            mod.setNombre(frame.txtNombre.getText());
            mod.setHumedad(Integer.parseInt(frame.txtHumedad.getText()));
            mod.setPresion(Float.parseFloat(frame.txtPresion.getText()));
            mod.setTemperatura(Float.parseFloat(frame.txtTemp.getText()));
                      
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
            frame.setVisible(false);
            frameAux.setVisible(true);
        }
        
        else if(e.getSource() == frame.btnModificar){
            String nombre = mod.getNombre();
            
            mod.setNombre(frame.txtNombre.getText());
            mod.setHumedad(Integer.parseInt(frame.txtHumedad.getText()));
            mod.setPresion(Float.parseFloat(frame.txtPresion.getText()));
            mod.setTemperatura(Float.parseFloat(frame.txtTemp.getText()));
            
            
            if(modC.modificar(mod, nombre)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            limpiar();
            frame.setVisible(false);
            frameAux.setVisible(true);
            modC.todosClimas(lista); 
            cargarTabla();
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
            int fila2 = frameAux.tbClima.getRowCount();
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
           modC.todosClimas(lista); 
           cargarTabla();
        }
        
        else if (e.getSource() == frameAux.mostrarBtn){
           try{
            int fila= frameAux.tbClima.getSelectedRow();
            
            mod.setNombre(frameAux.tbClima.getValueAt(fila, 0).toString());
        
            frame.txtNombre.setText(frameAux.tbClima.getValueAt(fila, 0).toString());
            frame.txtHumedad.setText(frameAux.tbClima.getValueAt(fila, 1).toString());
            frame.txtPresion.setText(frameAux.tbClima.getValueAt(fila, 2).toString());
            frame.txtTemp.setText(frameAux.tbClima.getValueAt(fila, 3).toString());
        
        
            frame.btnGuardar.setVisible(false);
            frame.btnEliminar.setVisible(true);
            frame.btnModificar.setVisible(true);
            
        frame.setVisible(true);
        frameAux.setVisible(false);
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Seleccione una fila");
           }
           
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
        
        else if(e.getSource() == frameAux.btnAgregar){
            int fila = frameAux.tbClima.getSelectedRow(); 
            
            String clima;
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            
            clima = frameAux.tbClima.getValueAt(fila, 0).toString();
            
            if(!this.modeloList.removeElement(clima)){
                this.modeloList.addElement(clima);
            }
            
            listaR.addElement(clima);
        } 
        
        else if (e.getSource() == frameAux.btnAceptar) {
            frameAux.setVisible(false);
        } 
                
            
         
            
        
        
        
       /* if(e.getSource()==frame.btnLimpiar){
            limpiar();
        }*/
        /*if(e.getSource()==frame.btnGuardar){
            cargarDatos();
            
        }*/
    }
    
    
    /*public void cargarDatos(){
        String []info = new String[4];
            info[0] = frame.txtNombre.getText();
            info[1] = frame.txtHumedad.getText();
            info[2] = frame.txtPresion.getText();
            info[3] = frame.txtTemp.getText();
            
            model.addRow(info);
    }*/
    
    /*public void eliminarFila(){
        int fila= frame.tbClima.getSelectedRow();
        if(fila>=0){
           model.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona una fila!!");
        }
    }*/
}
