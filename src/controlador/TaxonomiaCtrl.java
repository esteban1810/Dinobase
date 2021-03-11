package controlador;

import clase.Paleontologo;
import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import view.taxonomia.TaxonomiaIndex;
import view.taxonomia.TaxonomiaForm;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;

public class TaxonomiaCtrl implements ActionListener {
    private Taxonomia mod;
    private ConsultasTaxonomia modC;
    private TaxonomiaIndex frame;
    private TaxonomiaForm frmReg;
    private MenuCtrl ctrlM;
    private DefaultTableModel modelo;
    private ArrayList<Taxonomia> lista;
    
    public TaxonomiaCtrl(Taxonomia mod, ConsultasTaxonomia modC){
        this.mod=mod;
        this.modC=modC;
        this.frame=new TaxonomiaIndex();
        frmReg = new TaxonomiaForm();
        modelo = new DefaultTableModel();
        lista = new ArrayList();
        ctrlM = new MenuCtrl();
        
        this.frame.todoBtn.addActionListener(this);
        this.frame.mostrarBtn.addActionListener(this);
        this.frame.nuevoBtn.addActionListener(this);
        this.frame.buscarBtn.addActionListener(this);
        this.frame.regresarBtn.addActionListener(this);
        this.frame.setLocationRelativeTo(null);
        
        frmReg.modificarBtn1.addActionListener(this);
        frmReg.eliminarBtn1.addActionListener(this);
        frmReg.registrarBtn1.addActionListener(this);
        frmReg.regresarBtn1.addActionListener(this);
        frmReg.paleanBtn1.addActionListener(this);
        frmReg.agregarBtn1.addActionListener(this);
        frmReg.btnAgrPais.addActionListener(this);
        frmReg.setLocationRelativeTo(null);
        
        modC.todasTaxonomias(lista);
        cargarTabla();
    }
    
    public void iniciar(){
        frame.setTitle("Taxonomias");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == frmReg.registrarBtn1){
            ConsultasTaxo_Tiempo tt = new ConsultasTaxo_Tiempo();
            ConsultasTaxo_Pais tp = new ConsultasTaxo_Pais();
            DefaultListModel dlm;
            
            mod.setEspecie(frmReg.especieTF1.getText());
            mod.setReino(frmReg.reinoTF1.getText());
            mod.setDominio(frmReg.ordenTF1.getText());
            mod.setDominio(frmReg.dominioTF1.getText());
            mod.setFamilia(frmReg.familiaTF1.getText());
            mod.setClase(frmReg.claseTF1.getText());
            mod.setFilo(frmReg.filoTF1.getText());
            mod.setGenero(frmReg.generoTF1.getText());
            mod.setAltura(Double.parseDouble(frmReg.alturaTF1.getText()));
            mod.setLargo(Double.parseDouble(frmReg.largoTF1.getText()));
            mod.setPeso(Double.parseDouble(frmReg.pesoTF1.getText()));
            mod.setAlimentacion(frmReg.alimentacionTF1.getText());
            mod.setRegistrado(frmReg.registradoTF1.getText());
            mod.setPaleantologo(frmReg.paleantologoTF1.getText());
            frame.setVisible(true);
            frmReg.setVisible(false);
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            dlm = (DefaultListModel) this.frmReg.listaPaises.getModel();
            
            tt.registrar(mod.getEspecie(), TiempoCtrl.getListaR().toArray());
            tp.registrar(mod.getEspecie(), dlm.toArray());
            limpiar();
            
            modC.todasTaxonomias(lista);
            cargarTabla();
        } 
        
        else if(e.getSource() == frame.todoBtn){
            modC.todasTaxonomias(lista);
            cargarTabla();
        }
        
        else if(e.getSource()==frame.mostrarBtn){
            int fila = frame.tablaTaxonomias.getSelectedRow();
            ArrayList<String> tiempos;
            DefaultListModel modelTiempo;
            
            ArrayList<String> paises;
            DefaultListModel modelPais;
            
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
          
            mod.setEspecie(frame.tablaTaxonomias.getValueAt(fila,0).toString());
            
            tiempos = new ConsultasTaxo_Tiempo().getRelacionesTiempo(mod.getEspecie());
            modelTiempo = new DefaultListModel();
            for(int i=0; i<tiempos.size(); i++){
                modelTiempo.addElement(tiempos.get(i));
            }
            frmReg.listaT1.setModel(modelTiempo);
            
            
            paises = new ConsultasTaxo_Pais().getRelacionesPais(mod.getEspecie());
            modelPais = new DefaultListModel();
            
            for(int i=0; i<paises.size(); i++){
                modelPais.addElement(paises.get(i));
            }
            frmReg.listaPaises.setModel(modelPais);
            
//            lista = new ConsultasTaxo_Tiempo().getRelacionesTiempo(mod.getEspecie());
//            modelo = new DefaultListModel();
//            for(int i=0; i<lista.size(); i++){
//                modelo.addElement(lista.get(i));
//            }
//            frmReg.listaT.setModel(modelo);
            
            modC.buscar(mod);
            frmReg.setVisible(true);
            frame.setVisible(false);
            frmReg.especieTF1.setText(mod.getEspecie());
            frmReg.reinoTF1.setText(mod.getReino());
            frmReg.ordenTF1.setText(mod.getOrden());
            frmReg.dominioTF1.setText(mod.getDominio());
            frmReg.familiaTF1.setText(mod.getFamilia());
            frmReg.claseTF1.setText(mod.getClase());
            frmReg.filoTF1.setText(mod.getFilo());
            frmReg.generoTF1.setText(mod.getGenero());
            frmReg.alturaTF1.setText(Double.toString(mod.getAltura()));
            frmReg.largoTF1.setText(Double.toString(mod.getLargo()));
            frmReg.pesoTF1.setText(Double.toString(mod.getPeso()));
            frmReg.alimentacionTF1.setText(mod.getAlimentacion());
            frmReg.registradoTF1.setText(mod.getRegistrado());
            frmReg.paleantologoTF1.setText(mod.getPaleantologo());
            frmReg.setVisible(true);
            frame.setVisible(false);
            frmReg.eliminarBtn1.setVisible(true);
            frmReg.modificarBtn1.setVisible(true);
            frmReg.registrarBtn1.setVisible(false);
        } 
        
        else if(e.getSource()==frmReg.modificarBtn1){
            String especie =  mod.getEspecie();
            ConsultasTaxo_Tiempo tt = new ConsultasTaxo_Tiempo();
            ConsultasTaxo_Pais tp = new ConsultasTaxo_Pais();
            
            mod.setEspecie(frmReg.especieTF1.getText());
            mod.setReino(frmReg.reinoTF1.getText());
            mod.setOrden(frmReg.ordenTF1.getText());
            mod.setDominio(frmReg.dominioTF1.getText());
            mod.setFamilia(frmReg.familiaTF1.getText());
            mod.setClase(frmReg.claseTF1.getText());
            mod.setFilo(frmReg.filoTF1.getText());
            mod.setGenero(frmReg.generoTF1.getText());
            mod.setAltura(Double.parseDouble(frmReg.alturaTF1.getText()));
            mod.setLargo(Double.parseDouble(frmReg.largoTF1.getText()));
            mod.setPeso(Double.parseDouble(frmReg.pesoTF1.getText()));
            mod.setAlimentacion(frmReg.alimentacionTF1.getText());
            mod.setRegistrado(frmReg.registradoTF1.getText());
            mod.setPaleantologo(frmReg.paleantologoTF1.getText());
            frame.setVisible(true);
            frmReg.setVisible(false);
            
            if(modC.modificar(mod, especie)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            
            ArrayList<String> listaTiempos = new ArrayList();
            ArrayList<String> listaPaises = new ArrayList();
            
            for(int i = 0; i< frmReg.listaT1.getModel().getSize();i++){
               listaTiempos.add(frmReg.listaT1.getModel().getElementAt(i));
            }
            
            tt.modificar(mod.getEspecie(), listaTiempos.toArray());
            
            for(int i = 0; i< frmReg.listaPaises.getModel().getSize();i++){
               listaPaises.add(frmReg.listaPaises.getModel().getElementAt(i));
            }
            
            tp.modificar(mod.getEspecie(), listaPaises.toArray());
            
            limpiar();
            modC.todasTaxonomias(lista);
            cargarTabla();
        }else if(e.getSource() == frmReg.eliminarBtn1){
            mod.setEspecie(frmReg.especieTF1.getText());
            frame.setVisible(true);
            frmReg.setVisible(false);
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            limpiar();
            modC.todasTaxonomias(lista);
            cargarTabla();
        } 
        
        else if(e.getSource()==frame.nuevoBtn){
            frame.setVisible(false);
            frmReg.setVisible(true);
            frmReg.eliminarBtn1.setVisible(false);
            frmReg.modificarBtn1.setVisible(false);
            frmReg.registrarBtn1.setVisible(true);
            limpiar();
            frmReg.registradoTF1.setText(MenuCtrl.getNickname());
            frmReg.listaPaises.setModel(new DefaultListModel());
        } 
        
        else if(e.getSource()==frmReg.regresarBtn1){
            frame.setVisible(true);
            frmReg.setVisible(false);
            limpiar();
        } 
        
        else if(e.getSource()==frame.buscarBtn){
            lista.clear();
            limpiarTabla();
            modC.coincidencias(lista, frame.buscarTF.getText());
            if(lista.size()==0){
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();
        } 
        
        else if(e.getSource()==frmReg.paleanBtn1){
            PaleontologoCtrl ctrlP = new PaleontologoCtrl(this.frmReg.paleantologoTF1);
            ctrlP.iniciar();
        } 
        
        else if(e.getSource()==frmReg.agregarBtn1){
            TiempoCtrl ctrlTiempo = new TiempoCtrl(new Tiempo(), new ConsultasTiempo(), (DefaultListModel)this.frmReg.listaT1.getModel());
            ctrlTiempo.iniciar();
        } 
        
        else if(e.getSource()==frame.regresarBtn){
            frame.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
        }
        
        else if(e.getSource() == frmReg.btnAgrPais){
            PaisCtrl ctrlPais = new PaisCtrl((DefaultListModel)this.frmReg.listaPaises.getModel());
            ctrlPais.iniciar();
        }
    }
    
    public void limpiar(){
        frmReg.especieTF1.setText(null);
        frmReg.reinoTF1.setText(null);
        frmReg.ordenTF1.setText(null);
        frmReg.dominioTF1.setText(null);
        frmReg.familiaTF1.setText(null);
        frmReg.claseTF1.setText(null);
        frmReg.filoTF1.setText(null);
        frmReg.generoTF1.setText(null);
        frmReg.alturaTF1.setText(null);
        frmReg.largoTF1.setText(null);
        frmReg.pesoTF1.setText(null);
        frmReg.alimentacionTF1.setText(null);
        frmReg.registradoTF1.setText(null);
        frmReg.paleantologoTF1.setText(null);
        frmReg.listaT1.setModel(new DefaultListModel());
    }
    
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        frame.tablaTaxonomias.setModel(modelo);
            
        modelo.addColumn("ESPECIE");
        modelo.addColumn("REINO");
        modelo.addColumn("ORDEN");
        modelo.addColumn("DOMINIO");
        modelo.addColumn("FAMILIA");
        modelo.addColumn("CLASE");
        modelo.addColumn("FILO");
        modelo.addColumn("GENERO");
        modelo.addColumn("ALTURA");
        modelo.addColumn("LARGO");
        modelo.addColumn("PESO");
        modelo.addColumn("ALIMENTACION");
        modelo.addColumn("REGISTRADO");
        modelo.addColumn("PALEANTOLOGO");

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
}


