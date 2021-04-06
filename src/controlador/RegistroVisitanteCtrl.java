package controlador;

import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import clase.Clima;
import modelo.ConsultasRegistrosV;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import clase.RegistroVisitante;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import view.diccionario.DiccionarioIndex;
import view.visitante.VisitanteIndex;

public class RegistroVisitanteCtrl implements ActionListener {

    String usuario;
    private ConsultasRegistrosV modC;
    private VisitanteIndex frm;
    private ArrayList<RegistroVisitante> listaRV;

    public RegistroVisitanteCtrl() {
        this.modC = new ConsultasRegistrosV();

        this.frm = new VisitanteIndex();
        frm.consultarBtn.addActionListener(this);
      
        listaRV = modC.todosRegistros();
    }

//    public static DefaultListModel getListaR(){
//        return listaR;
//    }
    public void iniciar() {
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.nombreTxt.setText(usuario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == frm.consultarBtn){
            DiccionarioCtrl ctrl = new DiccionarioCtrl();
            ctrl.iniciar();
            this.frm.setVisible(false);
        } 
        
    }

    
   

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

}
