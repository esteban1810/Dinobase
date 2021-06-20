/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clase.Pais;
import clase.Preguntas;
import clase.Taxonomia;
import clase.Tiempo;
import clase.Usuario;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasPais;
import modelo.ConsultasPreguntas;
import modelo.ConsultasTaxonomia;
import modelo.ConsultasTiempo;
import modelo.ConsultasUsuario;
import view.estadisticas.estadisticasIndex;
import view.quiz.QuizForm;
import view.quiz.quizIndex;

/**
 *
 * @author franc
 */
public class EstadisticasCtrl implements ActionListener{
    private ConsultasUsuario modeloUsuario;
    private estadisticasIndex estadisticas;
    private ArrayList<Usuario> lista;
    private DefaultTableModel modelo;
    private MenuCtrl menuCtrl;
    private Usuario user;
//
    public EstadisticasCtrl() {
        modeloUsuario = new ConsultasUsuario();
        this.estadisticas = new estadisticasIndex();
        this.menuCtrl = new MenuCtrl();
        this.user = new Usuario();
        this.estadisticas.regresarBtn.addActionListener(this);
        lista = modeloUsuario.Estadisticas();
        cargarTabla();
        misEstadisticas();
    }
    public void iniciar() {
        estadisticas.setVisible(true);
        estadisticas.setLocationRelativeTo(null);
    }
    
     public void actionPerformed(ActionEvent e) {
        if(e.getSource() == estadisticas.regresarBtn){
            estadisticas.setVisible(false);
            menuCtrl.iniciar();
            menuCtrl.desbloquear(menuCtrl.getNickname());
            menuCtrl.desbloquearVisitante();
        }
    }
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        estadisticas.tablaPuntajes.setModel(modelo);
        
        modelo.addColumn("Posición");
        modelo.addColumn("Usuario");
        modelo.addColumn("Puntaje");
        System.out.println(lista.size());
        Object[] fila;
        Object[] renglon = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            fila = lista.get(i).arreglo();
            renglon[0] = i+1;
            renglon[1]=fila[0];
            renglon[2]=fila[1];
            modelo.addRow(renglon);
        }
    }
    
    public void misEstadisticas(){
        this.estadisticas.nicknameTxt.setText(MenuCtrl.getNickname());
        user = modeloUsuario.PuntajeAnterior(MenuCtrl.getNickname());
        
        this.estadisticas.puntajeTxt.setText(String.valueOf(user.getPuntaje()));
    }
}
