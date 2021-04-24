package controlador;

import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import clase.Clima;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;

import view.diccionario.DiccionarioForm;
import view.diccionario.DiccionarioIndex;

public final class DiccionarioCtrl implements ActionListener, MouseListener, KeyListener, ItemListener{
    private MenuCtrl ctrlM;
    private DiccionarioIndex diccionarioIndex;
    private ArrayList<Taxonomia> listaVisitante;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    private DiccionarioForm diccionarioForm;
    private ConsultasTaxonomia taxonomiaModelo;
    private ConsultasClima climaModelo;
    private ConsultasTiempo tiempoModelo;
    private ConsultasPais paisModelo;

    
    public DiccionarioCtrl(){
        diccionarioIndex  = new DiccionarioIndex();
        
        //Componentes Interfaz DiccionarioForm
        diccionarioForm   = new DiccionarioForm();
        modelo          = new DefaultTableModel();
        modelo2         = new DefaultTableModel();
        modelo3         = new DefaultTableModel();
        
        ctrlM = new MenuCtrl();
        
        taxonomiaModelo = new ConsultasTaxonomia();
        climaModelo = new ConsultasClima();
        tiempoModelo = new ConsultasTiempo();
        paisModelo = new ConsultasPais();

        //Se vinculan los eventos
        actionListener();
        
        listaVisitante = taxonomiaModelo.indexVisitante();
        
        //Se cargan los ComboBox
        cargarPeriodoCB();
        cargarPaisCB();
        cargarPaleontologoCB();
        
        //Cargando la tabla
        cargarTabla();
    }
    
    public void actionListener(){
        this.diccionarioForm.regresarBtn.addActionListener(this);
        this.diccionarioIndex.regresarBtn.addActionListener(this);
        this.diccionarioIndex.setLocationRelativeTo(null);
        this.diccionarioForm.setLocationRelativeTo(null);
        this.diccionarioForm.mostrarClimaBtn.addActionListener(this);
        this.diccionarioIndex.tablaTaxonomias2.addMouseListener(this);
        this.diccionarioIndex.buscarTF.addKeyListener(this);
        this.diccionarioIndex.paleontologoCB.addItemListener(this);        
        this.diccionarioIndex.paisCB.addItemListener(this);
        this.diccionarioIndex.periodoCB.addItemListener(this);
    }
    
    public void cargarPeriodoCB(){
        new ConsultasTiempo().nombrePeriodos(diccionarioIndex.periodoCB);
    }
    
    public void cargarPaisCB(){
        new ConsultasPais().nombrePaises(diccionarioIndex.paisCB);
    }
    
    public void cargarPaleontologoCB(){
        new ConsultasPaleontologo().paleontologos(diccionarioIndex.paleontologoCB);
    }
    
    public void iniciar(){
        diccionarioIndex.setVisible(true);
        diccionarioIndex.setTitle("Tiempo");
        diccionarioIndex.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == diccionarioForm.mostrarClimaBtn){
            mostrarClimaBtn();
        }
//         
        else if (diccionarioForm.regresarBtn == e.getSource()) {
            diccionarioForm.setVisible(false);
            diccionarioIndex.setVisible(true);
            cargarTabla();
        }
        
        else if(e.getSource() == diccionarioIndex.regresarBtn){
            diccionarioIndex.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());
            ctrlM.desbloquearVisitante();
        }
        
  
    }
    
    public void buscarBtn(){
        String pais     = diccionarioIndex.paisCB.getSelectedItem().toString();
        String periodo  = diccionarioIndex.periodoCB.getSelectedItem().toString();
        String paleonto  = diccionarioIndex.paleontologoCB.getSelectedItem().toString();
        String especie  = diccionarioIndex.buscarTF.getText();
        
        if(pais.equals("-- Seleccionar --")){
            pais="";
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
                if(paleonto.equals("-- Seleccionar --")){
                    paleonto="";
                    if(especie.isEmpty()){
                        listaVisitante = taxonomiaModelo.indexVisitante();
                            cargarTabla();
                        return;
                    }
                }
            } else
                if(paleonto.equals("-- Seleccionar --"))paleonto="";
        } else {
            if(periodo.equals("-- Seleccionar --")){
                periodo="";
                if(paleonto.equals("-- Seleccionar --")) paleonto="";
            } else if(paleonto.equals("-- Seleccionar --")) paleonto="";
        }
        
        listaVisitante=taxonomiaModelo.coincidenciasVisitante(especie, paleonto, periodo, pais);
        
        if (listaVisitante.isEmpty()) return;
        
        cargarTabla();
    }
    
    public void cargarTabla(){
       modelo = new DefaultTableModel();
       diccionarioIndex.tablaTaxonomias2.setModel(modelo);
       Object[] fila;

       modelo.addColumn("Especie");
       modelo.addColumn("Paleontologo");
       modelo.addColumn("Tiempos");
       modelo.addColumn("Paises");

       for(int i=0; i<listaVisitante.size(); i++){
           fila = listaVisitante.get(i).arregloVisitante();
           modelo.addRow(fila);
       }
   }

    private void mostrarClimaBtn() {
        int fila = diccionarioForm.tablaPaises.getSelectedRow();
        ArrayList<Clima> listaT = new ArrayList();
        modelo3 =new DefaultTableModel();
        diccionarioForm.climaLbl.setVisible(true);
        diccionarioForm.tablaClimas.setModel(modelo3);

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }

        modelo3.addColumn("Nombre");
        modelo3.addColumn("Humedad");
        modelo3.addColumn("Presion");
        modelo3.addColumn("Temperatura");

        
        String nombrePais = diccionarioForm.tablaPaises.getValueAt(fila, 0).toString();
        listaT = climaModelo.getClimas(nombrePais);

        for (int i = 0; i < listaT.size(); i++) {
            modelo3.addRow(listaT.get(i).arreglo());
        }
    }

    private void mostrarBtn() {
        int fila = diccionarioIndex.tablaTaxonomias2.getSelectedRow();
        ArrayList<Tiempo> listaT;
        ArrayList<Pais> listaT1;
        modelo=new DefaultTableModel();
        modelo2 = new DefaultTableModel();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        
        ConsultasTaxonomia modT = new ConsultasTaxonomia();
        Taxonomia mod = new Taxonomia();

        mod.setEspecie(diccionarioIndex.tablaTaxonomias2.getValueAt(fila, 0).toString());
        modT.buscar(mod);

        diccionarioForm.especieTF.setText(mod.getEspecie());
        diccionarioForm.reinoTF.setText(mod.getReino());
        diccionarioForm.ordenTF.setText(mod.getOrden());
        diccionarioForm.dominioTF.setText(mod.getDominio());
        diccionarioForm.familiaTF.setText(mod.getFamilia());
        diccionarioForm.claseTF.setText(mod.getClase());
        diccionarioForm.filoTF.setText(mod.getFilo());
        diccionarioForm.generoTF.setText(mod.getGenero());
        diccionarioForm.alturaTF.setText(Double.toString(mod.getAltura()));
        diccionarioForm.largoTF.setText(Double.toString(mod.getLargo()));
        diccionarioForm.pesoTF.setText(Double.toString(mod.getPeso()));
        diccionarioForm.alimentacionTF.setText(mod.getAlimentacion());
        diccionarioForm.registradoTF.setText(mod.getRegistrado());
        diccionarioForm.paleantologoTF.setText(mod.getPaleantologo());
        diccionarioForm.descripcionTXA.append(mod.getDescripcion());

        if (mod.getLeerImagen() != null) {
            try {
                BufferedImage bi = ImageIO.read(mod.getLeerImagen());
                ImageIcon foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(250, 260, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                this.diccionarioForm.lblFoto.setIcon(newicon);
            } catch (Exception ex) {
                System.out.println("No paso la imagen");
            }
        }

        diccionarioForm.setVisible(true);
        diccionarioIndex.setVisible(false);

        diccionarioForm.tablaTiempos.setModel(modelo);

        modelo.addColumn("Periodo");
        modelo.addColumn("Era");
        modelo.addColumn("Epoca");
        modelo.addColumn("Descubierto");
        

        listaT = tiempoModelo.getTiempos(mod.getEspecie());

        for (int i = 0; i < listaT.size(); i++) {
            modelo.addRow(listaT.get(i).arreglo());
        }

        diccionarioForm.tablaPaises.setModel(modelo2);

        modelo2.addColumn("Pais");
        modelo2.addColumn("Continente");
        modelo2.addColumn("Extension");

        listaT1 = paisModelo.getPaises(mod.getEspecie());

        for (int i = 0; i < listaT1.size(); i++) {
            modelo2.addRow(listaT1.get(i).arreglo());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==this.diccionarioIndex.tablaTaxonomias2){
            this.mostrarBtn();
        } 
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
//        if(ke.getSource()==this.diccionarioIndex.buscarTF){
////            System.out.println("todo excelente Pressed");
//            buscarBtn();
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource()==this.diccionarioIndex.buscarTF){
            buscarBtn();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==this.diccionarioIndex.paleontologoCB){
            buscarBtn();
        }
        if(ie.getSource()==this.diccionarioIndex.paisCB){
            buscarBtn();
        }
        if(ie.getSource()==this.diccionarioIndex.periodoCB){
            buscarBtn();
        }
    }
   
}
