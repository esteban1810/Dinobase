package controlador;

import clase.Taxonomia;
import java.awt.Graphics;
import java.awt.Image;
import view.taxonomia.TaxonomiaIndex;
import view.taxonomia.TaxonomiaForm;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.*;

public final class TaxonomiaCtrl implements ActionListener {

    private final Taxonomia taxonomia;
    private final ConsultasTaxonomia taxonomiaModelo;
    private final TaxonomiaIndex taxonomiaIndex;
    private final TaxonomiaForm taxonomiaForm;
    private final MenuCtrl menuCtrl;
    private DefaultTableModel modelo;
    private ArrayList<Taxonomia> lista;
    private int longitudBytes;
    JFileChooser j = new JFileChooser();
    FileInputStream imagen;
    int tam;
    
    
    public TaxonomiaCtrl() {
        this.taxonomia = new Taxonomia();
        this.taxonomiaModelo = new ConsultasTaxonomia();
        this.taxonomiaIndex = new TaxonomiaIndex();
        taxonomiaForm = new TaxonomiaForm();

        modelo = new DefaultTableModel();
        menuCtrl = new MenuCtrl();

        this.taxonomiaIndex.todoBtn.addActionListener(this);
        this.taxonomiaIndex.mostrarBtn.addActionListener(this);
        this.taxonomiaIndex.nuevoBtn.addActionListener(this);
        this.taxonomiaIndex.buscarBtn.addActionListener(this);
        this.taxonomiaIndex.regresarBtn.addActionListener(this);
        this.taxonomiaIndex.setLocationRelativeTo(null);

        taxonomiaForm.modificarBtn1.addActionListener(this);
        taxonomiaForm.eliminarBtn1.addActionListener(this);
        taxonomiaForm.registrarBtn1.addActionListener(this);
        taxonomiaForm.regresarBtn1.addActionListener(this);
        taxonomiaForm.paleanBtn1.addActionListener(this);
        taxonomiaForm.agregarBtn1.addActionListener(this);
        taxonomiaForm.btnAgrPais.addActionListener(this);
        taxonomiaForm.btnAgrImagen.addActionListener(this);
        taxonomiaForm.setLocationRelativeTo(null);

        lista = taxonomiaModelo.index();
        cargarTabla();
        this.cargarPeriodoCB();
        this.cargarPaisCB();
    }

    public void iniciar() {
        taxonomiaIndex.setTitle("Taxonomias");
        taxonomiaIndex.setLocationRelativeTo(null);
        taxonomiaIndex.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == taxonomiaForm.registrarBtn1) {
            presionarRegistrarBtn1();
        } else if (e.getSource() == taxonomiaIndex.todoBtn) {
            lista = taxonomiaModelo.index();
            cargarTabla();
        } else if (e.getSource() == taxonomiaIndex.mostrarBtn) {
            presionarMostrarBtn();

        } else if (e.getSource() == taxonomiaForm.modificarBtn1) {
            presionarModificarBtn1();
        } else if (e.getSource() == taxonomiaForm.eliminarBtn1) {
            presionarEliminarBtn1();
        } else if (e.getSource() == taxonomiaIndex.nuevoBtn) {
            presionarNuevoBtn();
        } else if (e.getSource() == taxonomiaForm.regresarBtn1) {
            taxonomiaIndex.setVisible(true);
            taxonomiaForm.setVisible(false);
            limpiar();
        } else if (e.getSource() == taxonomiaIndex.buscarBtn) {
            presionarBuscarBtn();
        } else if (e.getSource() == taxonomiaForm.paleanBtn1) {
            PaleontologoCtrl ctrlP = new PaleontologoCtrl(this.taxonomiaForm.paleantologoTF1);
            ctrlP.iniciar();
        } else if (e.getSource() == taxonomiaForm.agregarBtn1) {
            TiempoCtrl ctrlTiempo = new TiempoCtrl((DefaultListModel) this.taxonomiaForm.listaT1.getModel());
            ctrlTiempo.iniciar();
        } else if (e.getSource() == taxonomiaIndex.regresarBtn) {
            taxonomiaIndex.setVisible(false);
            menuCtrl.iniciar();
            menuCtrl.desbloquear(menuCtrl.getNickname());
        } else if (e.getSource() == taxonomiaForm.btnAgrPais) {
            PaisCtrl ctrlPais = new PaisCtrl((DefaultListModel) this.taxonomiaForm.listaPaises.getModel());
            ctrlPais.iniciar();
        } else if (e.getSource() == taxonomiaForm.btnAgrImagen) {
            this.agregarFileChooser();
        }
    }

    public void cargarPeriodoCB() {
        new ConsultasTiempo().nombrePeriodos(taxonomiaIndex.periodoCB);
    }

    public void cargarPaisCB() {
        new ConsultasPais().nombrePaises(taxonomiaIndex.paisCB);
    }

    public void limpiar(){
        taxonomiaForm.especieTF1.setText(null);
        taxonomiaForm.reinoTF1.setText(null);
        taxonomiaForm.ordenTF1.setText(null);
        taxonomiaForm.dominioTF1.setText(null);
        taxonomiaForm.familiaTF1.setText(null);
        taxonomiaForm.claseTF1.setText(null);
        taxonomiaForm.filoTF1.setText(null);
        taxonomiaForm.generoTF1.setText(null);
        taxonomiaForm.alturaTF1.setText(null);
        taxonomiaForm.largoTF1.setText(null);
        taxonomiaForm.pesoTF1.setText(null);
        taxonomiaForm.alimentacionTF1.setText(null);
        taxonomiaForm.registradoTF1.setText(null);
        taxonomiaForm.paleantologoTF1.setText(null);
        this.taxonomiaForm.lblFoto.setIcon(null);
        taxonomiaForm.descripcionTxa.setText("");
        taxonomiaForm.listaT1.setModel(new DefaultListModel());
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        taxonomiaIndex.tablaTaxonomias.setModel(modelo);

        modelo.addColumn("IMAGEN");
        modelo.addColumn("ESPECIE");
        modelo.addColumn("PERIODO");
        modelo.addColumn("PAIS(ES)");

        for(int i=0; i<lista.size(); i++){
            modelo.addRow(lista.get(i).arreglo());
        }
    }
            
//>>>>>>> filtracion
      

    public void limpiarTabla() {
        int filas = modelo.getRowCount();
        System.out.println(modelo.getRowCount());
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    private void presionarRegistrarBtn1() {
        ConsultasTaxo_Tiempo tt = new ConsultasTaxo_Tiempo();
        ConsultasTaxo_Pais tp = new ConsultasTaxo_Pais();
        DefaultListModel listModelPais = (DefaultListModel) this.taxonomiaForm.listaPaises.getModel();
        DefaultListModel listModelTiempo = (DefaultListModel) this.taxonomiaForm.listaT1.getModel();

        taxonomia.setEspecie(taxonomiaForm.especieTF1.getText());
        taxonomia.setReino(taxonomiaForm.reinoTF1.getText());
        taxonomia.setDominio(taxonomiaForm.ordenTF1.getText());
        taxonomia.setDominio(taxonomiaForm.dominioTF1.getText());
        taxonomia.setFamilia(taxonomiaForm.familiaTF1.getText());
        taxonomia.setClase(taxonomiaForm.claseTF1.getText());
        taxonomia.setFilo(taxonomiaForm.filoTF1.getText());
        taxonomia.setGenero(taxonomiaForm.generoTF1.getText());
        taxonomia.setAltura(Double.parseDouble(taxonomiaForm.alturaTF1.getText()));
        taxonomia.setLargo(Double.parseDouble(taxonomiaForm.largoTF1.getText()));
        taxonomia.setPeso(Double.parseDouble(taxonomiaForm.pesoTF1.getText()));
        taxonomia.setAlimentacion(taxonomiaForm.alimentacionTF1.getText());
        taxonomia.setRegistrado(taxonomiaForm.registradoTF1.getText());
        taxonomia.setPaleantologo(taxonomiaForm.paleantologoTF1.getText());
        taxonomia.setDescripcion(taxonomiaForm.descripcionTxa.getText());
        taxonomia.setImagenNom(this.obtenerImagen());
        taxonomia.setImagenTam(this.obtenerTamanio());
        taxonomiaIndex.setVisible(true);
        taxonomiaForm.setVisible(false);

        if (taxonomiaModelo.registrar(taxonomia)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }

        tt.registrar(taxonomia.getEspecie(), listModelTiempo.toArray());
        tp.registrar(taxonomia.getEspecie(), listModelPais.toArray());
        limpiar();
        
        lista=taxonomiaModelo.index();
        cargarTabla();
    }

    private void presionarMostrarBtn(){
        int fila = taxonomiaIndex.tablaTaxonomias.getSelectedRow();
        ArrayList<String> tiempos;
        DefaultListModel modelTiempo;
        InputStream is = null;

        ArrayList<String> paises;
        DefaultListModel modelPais;

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }

        taxonomia.setEspecie(taxonomiaIndex.tablaTaxonomias.getValueAt(fila, 1).toString());

        tiempos = new ConsultasTaxo_Tiempo().getRelacionesTiempo(taxonomia.getEspecie());
        modelTiempo = new DefaultListModel();
        for (int i = 0; i < tiempos.size(); i++) {
            modelTiempo.addElement(tiempos.get(i));
        }
        taxonomiaForm.listaT1.setModel(modelTiempo);

        paises = new ConsultasTaxo_Pais().getRelacionesPais(taxonomia.getEspecie());
        modelPais = new DefaultListModel();

        for (int i = 0; i < paises.size(); i++) {
            modelPais.addElement(paises.get(i));
        }
        taxonomiaForm.listaPaises.setModel(modelPais);

        taxonomiaModelo.buscar(taxonomia);
        taxonomiaForm.setVisible(true);
        taxonomiaIndex.setVisible(false);
        taxonomiaForm.especieTF1.setText(taxonomia.getEspecie());
        taxonomiaForm.reinoTF1.setText(taxonomia.getReino());
        taxonomiaForm.ordenTF1.setText(taxonomia.getOrden());
        taxonomiaForm.dominioTF1.setText(taxonomia.getDominio());
        taxonomiaForm.familiaTF1.setText(taxonomia.getFamilia());
        taxonomiaForm.claseTF1.setText(taxonomia.getClase());
        taxonomiaForm.filoTF1.setText(taxonomia.getFilo());
        taxonomiaForm.generoTF1.setText(taxonomia.getGenero());
        taxonomiaForm.alturaTF1.setText(Double.toString(taxonomia.getAltura()));
        taxonomiaForm.largoTF1.setText(Double.toString(taxonomia.getLargo()));
        taxonomiaForm.pesoTF1.setText(Double.toString(taxonomia.getPeso()));
        taxonomiaForm.alimentacionTF1.setText(taxonomia.getAlimentacion());
        taxonomiaForm.registradoTF1.setText(taxonomia.getRegistrado());
        taxonomiaForm.paleantologoTF1.setText(taxonomia.getPaleantologo());
//        taxonomia.setImagenNom((FileInputStream) taxonomia.getLeerImagen());
        if (taxonomia.getLeerImagen() != null) {
            try {
                BufferedImage bi = ImageIO.read(taxonomia.getLeerImagen());
                ImageIcon foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(280, 350, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                this.taxonomiaForm.lblFoto.setIcon(newicon);
            } catch (Exception ex) {
                System.out.println("No paso la imagen");
            }
        } else {
            this.taxonomiaForm.lblFoto.setText("No hay imagen");
        }
        
        taxonomiaForm.descripcionTxa.append(taxonomia.getDescripcion());
        taxonomiaForm.setVisible(true);
        taxonomiaIndex.setVisible(false);
        taxonomiaForm.eliminarBtn1.setVisible(true);
        taxonomiaForm.modificarBtn1.setVisible(true);
        taxonomiaForm.registrarBtn1.setVisible(false);
    }

    private void presionarModificarBtn1() {
        String especie = taxonomia.getEspecie();
        ConsultasTaxo_Tiempo tt = new ConsultasTaxo_Tiempo();
        ConsultasTaxo_Pais tp = new ConsultasTaxo_Pais();
        ImageIcon foto;

        taxonomia.setEspecie(taxonomiaForm.especieTF1.getText());
        taxonomia.setReino(taxonomiaForm.reinoTF1.getText());
        taxonomia.setOrden(taxonomiaForm.ordenTF1.getText());
        taxonomia.setDominio(taxonomiaForm.dominioTF1.getText());
        taxonomia.setFamilia(taxonomiaForm.familiaTF1.getText());
        taxonomia.setClase(taxonomiaForm.claseTF1.getText());
        taxonomia.setFilo(taxonomiaForm.filoTF1.getText());
        taxonomia.setGenero(taxonomiaForm.generoTF1.getText());
        taxonomia.setAltura(Double.parseDouble(taxonomiaForm.alturaTF1.getText()));
        taxonomia.setLargo(Double.parseDouble(taxonomiaForm.largoTF1.getText()));
        taxonomia.setPeso(Double.parseDouble(taxonomiaForm.pesoTF1.getText()));
        taxonomia.setAlimentacion(taxonomiaForm.alimentacionTF1.getText());
        taxonomia.setRegistrado(taxonomiaForm.registradoTF1.getText());
        taxonomia.setPaleantologo(taxonomiaForm.paleantologoTF1.getText());
        taxonomia.setDescripcion(taxonomiaForm.descripcionTxa.getText());
        taxonomiaIndex.setVisible(true);
        taxonomiaForm.setVisible(false);

        if (taxonomiaModelo.modificar(taxonomia, especie)) {
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }

        ArrayList<String> listaTiempos = new ArrayList();
        ArrayList<String> listaPaises = new ArrayList();

        for (int i = 0; i < taxonomiaForm.listaT1.getModel().getSize(); i++) {
            listaTiempos.add(taxonomiaForm.listaT1.getModel().getElementAt(i));
        }

        tt.modificar(taxonomia.getEspecie(), listaTiempos.toArray());

        for (int i = 0; i < taxonomiaForm.listaPaises.getModel().getSize(); i++) {
            listaPaises.add(taxonomiaForm.listaPaises.getModel().getElementAt(i));
        }

        tp.modificar(taxonomia.getEspecie(), listaPaises.toArray());

        limpiar();
        lista = taxonomiaModelo.index();
        cargarTabla(); 
    }

    private void presionarEliminarBtn1() {
        taxonomia.setEspecie(taxonomiaForm.especieTF1.getText());
        taxonomiaIndex.setVisible(true);
        taxonomiaForm.setVisible(false);

        if (taxonomiaModelo.eliminar(taxonomia)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        limpiar();
        lista = taxonomiaModelo.index();
        cargarTabla();
    }

    private void presionarNuevoBtn() {
        taxonomiaIndex.setVisible(false);
        taxonomiaForm.setVisible(true);
        taxonomiaForm.eliminarBtn1.setVisible(false);
        taxonomiaForm.modificarBtn1.setVisible(false);
        limpiar();
        taxonomiaForm.registradoTF1.setText(MenuCtrl.getNickname());
        taxonomiaForm.listaPaises.setModel(new DefaultListModel());
    }

    private void presionarBuscarBtn() {
        String pais = this.taxonomiaIndex.paisCB.getSelectedItem().toString();
        String periodo = this.taxonomiaIndex.periodoCB.getSelectedItem().toString();
        String especie = taxonomiaIndex.buscarTF.getText();
        ArrayList<Taxonomia> listaAux;
        
        
        if(pais.equals("-- Seleccionar --")){
            pais="";
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
                if(especie.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Especifique algún campo de búsqueda");
                    return;
                }
            }
        } else {
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
            }
        }
        

        listaAux = taxonomiaModelo.coincidencias(especie,periodo,pais);
        
        if(listaAux.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            return;
        }
        
        lista = listaAux;
        limpiarTabla();
        cargarTabla();
    }

    private void agregarFileChooser() {
        this.taxonomiaForm.lblFoto.setIcon(null);

        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(j.getSelectedFile());
                this.cargarImagen(fis);
                //necesitamos saber la cantidad de bytes
                this.cargarTamanio((int) j.getSelectedFile().length());
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(this.taxonomiaForm.lblFoto.getWidth(), this.taxonomiaForm.lblFoto.getHeight(), Image.SCALE_DEFAULT);
                    this.taxonomiaForm.lblFoto.setIcon(new ImageIcon(icono));
                    this.taxonomiaForm.lblFoto.updateUI();

                } catch (IOException ex) {
                    System.out.println("No se hizo la insercion de imagen");
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private FileInputStream obtenerImagen(){
        return imagen;
    }
    
    private void cargarImagen(FileInputStream imagen){
        this.imagen = imagen;
    }
    
    private int obtenerTamanio(){
        return tam;
    }
    
    private void cargarTamanio(int tam){
        this.tam = tam;
    }

    
}


