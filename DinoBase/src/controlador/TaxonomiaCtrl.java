package controlador;

import framesTaxonomia.TaxonomiaFrame;
import framesTaxonomia.TaxonomiaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasTaxonomia;
import modelo.Taxonomia;

public class TaxonomiaCtrl implements ActionListener {
    private Taxonomia mod;
    private ConsultasTaxonomia modC;
    private TaxonomiaFrame frame;
    private TaxonomiaRegistro frmReg;
    DefaultTableModel modelo;
    ArrayList<Taxonomia> lista;
    
    public TaxonomiaCtrl(Taxonomia mod, ConsultasTaxonomia modC, TaxonomiaFrame frame){
        this.mod=mod;
        this.modC=modC;
        this.frame=frame;
        frmReg = new TaxonomiaRegistro();
        modelo = new DefaultTableModel();
        lista = new ArrayList();
        
        this.frame.todoBtn.addActionListener(this);
        this.frame.mostrarBtn.addActionListener(this);
        this.frame.nuevoBtn.addActionListener(this);
        this.frame.buscarBtn.addActionListener(this);
        this.frame.setLocationRelativeTo(null);
        
        frmReg.modificarBtn.addActionListener(this);
        frmReg.eliminarBtn.addActionListener(this);
        frmReg.registrarBtn.addActionListener(this);
        frmReg.regresarBtn.addActionListener(this);
        frmReg.setLocationRelativeTo(null);
        
        modC.todasTaxonomias(lista);
        cargarTabla();
    }
    
    public TaxonomiaCtrl(Taxonomia mod, ConsultasTaxonomia modC, TaxonomiaRegistro frmReg){
        this.mod=mod;
        this.modC=modC;
        this.frmReg=frmReg;
    }
    
    public void iniciar(){
        frame.setTitle("Taxonomias");
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == frmReg.registrarBtn){
            mod.setEspecie(frmReg.especieTF.getText());
            mod.setReino(frmReg.reinoTF.getText());
            mod.setDominio(frmReg.ordenTF.getText());
            mod.setDominio(frmReg.dominioTF.getText());
            mod.setFamilia(frmReg.familiaTF.getText());
            mod.setClase(frmReg.claseTF.getText());
            mod.setFilo(frmReg.filoTF.getText());
            mod.setGenero(frmReg.generoTF.getText());
            mod.setAltura(Double.parseDouble(frmReg.alturaTF.getText()));
            mod.setLargo(Double.parseDouble(frmReg.largoTF.getText()));
            mod.setPeso(Double.parseDouble(frmReg.pesoTF.getText()));
            mod.setAlimentacion(frmReg.alimentacionTF.getText());
            mod.setRegistrado(frmReg.registradoTF.getText());
            mod.setPaleantologo(frmReg.paleantologoTF.getText());
            frame.setVisible(true);
            frmReg.setVisible(false);
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
            modC.todasTaxonomias(lista);
            cargarTabla();
        } else if(e.getSource() == frame.todoBtn){
            modC.todasTaxonomias(lista);
            cargarTabla();
        }else if(e.getSource()==frame.mostrarBtn){
            int fila = frame.tablaTaxonomias.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            mod.setEspecie(frame.tablaTaxonomias.getValueAt(fila,0).toString());
            modC.buscar(mod);
            frmReg.setVisible(true);
            frame.setVisible(false);
            frmReg.especieTF.setText(mod.getEspecie());
            frmReg.reinoTF.setText(mod.getReino());
            frmReg.ordenTF.setText(mod.getOrden());
            frmReg.dominioTF.setText(mod.getDominio());
            frmReg.familiaTF.setText(mod.getFamilia());
            frmReg.claseTF.setText(mod.getClase());
            frmReg.filoTF.setText(mod.getFilo());
            frmReg.generoTF.setText(mod.getGenero());
            frmReg.alturaTF.setText(Double.toString(mod.getAltura()));
            frmReg.largoTF.setText(Double.toString(mod.getLargo()));
            frmReg.pesoTF.setText(Double.toString(mod.getPeso()));
            frmReg.alimentacionTF.setText(mod.getAlimentacion());
            frmReg.registradoTF.setText(mod.getRegistrado());
            frmReg.paleantologoTF.setText(mod.getPaleantologo());
            frmReg.setVisible(true);
            frame.setVisible(false);
            frmReg.eliminarBtn.setVisible(true);
            frmReg.modificarBtn.setVisible(true);
            frmReg.registrarBtn.setVisible(false);
        } else if(e.getSource()==frmReg.modificarBtn){
            mod.setEspecie(frmReg.especieTF.getText());
            mod.setReino(frmReg.reinoTF.getText());
            mod.setOrden(frmReg.ordenTF.getText());
            mod.setDominio(frmReg.dominioTF.getText());
            mod.setFamilia(frmReg.familiaTF.getText());
            mod.setClase(frmReg.claseTF.getText());
            mod.setFilo(frmReg.filoTF.getText());
            mod.setGenero(frmReg.generoTF.getText());
            mod.setAltura(Double.parseDouble(frmReg.alturaTF.getText()));
            mod.setLargo(Double.parseDouble(frmReg.largoTF.getText()));
            mod.setPeso(Double.parseDouble(frmReg.pesoTF.getText()));
            mod.setAlimentacion(frmReg.alimentacionTF.getText());
            mod.setRegistrado(frmReg.registradoTF.getText());
            mod.setPaleantologo(frmReg.paleantologoTF.getText());
            frame.setVisible(true);
            frmReg.setVisible(false);
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            limpiar();
            modC.todasTaxonomias(lista);
            cargarTabla();
        }else if(e.getSource() == frmReg.eliminarBtn){
            mod.setEspecie(frmReg.especieTF.getText());
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
        } else if(e.getSource()==frame.nuevoBtn){
            frame.setVisible(false);
            frmReg.setVisible(true);
            frmReg.eliminarBtn.setVisible(false);
            frmReg.modificarBtn.setVisible(false);
            frmReg.registrarBtn.setVisible(true);
            limpiar();
        } else if(e.getSource()==frmReg.regresarBtn){
            frame.setVisible(true);
            frmReg.setVisible(false);
            limpiar();
        } else if(e.getSource()==frame.buscarBtn){
            lista.clear();
            limpiarTabla();
            modC.coincidencias(lista, frame.buscarTF.getText());
            if(lista.size()==0){
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();
        }
    }
    
    public void limpiar(){
        frmReg.especieTF.setText(null);
        frmReg.reinoTF.setText(null);
        frmReg.ordenTF.setText(null);
        frmReg.dominioTF.setText(null);
        frmReg.familiaTF.setText(null);
        frmReg.claseTF.setText(null);
        frmReg.filoTF.setText(null);
        frmReg.generoTF.setText(null);
        frmReg.alturaTF.setText(null);
        frmReg.largoTF.setText(null);
        frmReg.pesoTF.setText(null);
        frmReg.alimentacionTF.setText(null);
        frmReg.registradoTF.setText(null);
        frmReg.paleantologoTF.setText(null);
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


