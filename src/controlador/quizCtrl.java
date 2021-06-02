package controlador;

import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import clase.Clima;
import clase.Preguntas;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import clase.RegistroVisitante;
import clase.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import view.quiz.QuizForm;
import view.quiz.quizIndex;

public class quizCtrl implements ActionListener {

    private ConsultasTaxonomia modC;
    private quizIndex quizIndex;
    private QuizForm QuizForm;
    private ArrayList<Taxonomia> lista;
    private DefaultTableModel modelo;
    private ConsultasUsuario usuarioModelo;
    private ConsultasPais paisModelo;
    private ConsultasPreguntas preguntaModelo;
    private MenuCtrl menuCtrl;
    private Usuario usuario;

    public quizCtrl() {
        this.modC = new ConsultasTaxonomia();
        this.quizIndex = new quizIndex();
        this.QuizForm = new QuizForm();
        this.menuCtrl = new MenuCtrl();
        this.usuario = new Usuario();
        this.quizIndex.jugarBtn.addActionListener(this);
        this.QuizForm.calificarBtn.addActionListener(this);
        this.quizIndex.regresarBtn.addActionListener(this);
        this.QuizForm.regresarBtn.addActionListener(this);
        usuarioModelo = new ConsultasUsuario();
        paisModelo = new ConsultasPais();
        preguntaModelo = new ConsultasPreguntas();
//        this.modelo = new DefaultTableModel();
//        this.frm..addActionListener(this);
        lista = modC.index();
        cargarTabla();
    }

//    public static DefaultListModel getListaR(){
//        return listaR;
//    }
    public void iniciar() {
        quizIndex.setVisible(true);
        quizIndex.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quizIndex.jugarBtn) {
            int fila = quizIndex.tablaTaxonomias2.getSelectedRow();
            Object[] renglon = new Object[4];
            ArrayList<Tiempo> listaT = new ArrayList();
            ArrayList<Pais> listaT1 = new ArrayList();
            ArrayList<Preguntas> preguntasFacil = new ArrayList();
            ArrayList<Preguntas> preguntasNormal = new ArrayList();
            ArrayList<Preguntas> preguntasDificil = new ArrayList();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            ConsultasTaxonomia modT = new ConsultasTaxonomia();
            Taxonomia mod = new Taxonomia();

            mod.setEspecie(quizIndex.tablaTaxonomias2.getValueAt(fila, 0).toString());
            modT.buscar(mod);
            listaT1 = paisModelo.getPaises(mod.getEspecie());

            if (mod.getLeerImagen() != null) {
                try {
                    BufferedImage bi = ImageIO.read(mod.getLeerImagen());
                    ImageIcon foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image newimg = img.getScaledInstance(220, 230, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    this.QuizForm.lblFoto.setIcon(newicon);
                } catch (Exception ex) {
                    System.out.println("No paso la imagen");
                }
            }
            QuizForm.nombreEspecieLbl.setText(mod.getEspecie());

            ConsultasPreguntas modP = new ConsultasPreguntas();
            Preguntas modP1 = new Preguntas();
            modP.buscar(preguntasFacil, "Facil");
            modP.buscar(preguntasNormal, "Normal");
            modP.buscar(preguntasDificil, "Dificil");
            quizIndex.setVisible(false);
            QuizForm.setVisible(true);
            QuizForm.setLocationRelativeTo(null);
            mostrarPreguntas(preguntasFacil, preguntasNormal, preguntasDificil, quizIndex.dificultadCB.getSelectedItem().toString());

        } else if (e.getSource() == QuizForm.calificarBtn) {
            this.calificar(QuizForm.respuestaTxt.getText(), QuizForm.respuesta1Txt.getText(), QuizForm.respuesta2Txt.getText(), QuizForm.respuesta3Txt.getText(), QuizForm.respuesta4Txt.getText());
        } else if(e.getSource() == quizIndex.regresarBtn){
            quizIndex.setVisible(false);
            menuCtrl.iniciar();
            menuCtrl.desbloquear(menuCtrl.getNickname());
            menuCtrl.desbloquearVisitante();
        } else if(e.getSource() == QuizForm.regresarBtn){
            QuizForm.setVisible(false);
            quizIndex.setVisible(true);
            
        }
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        quizIndex.tablaTaxonomias2.setModel(modelo);

        modelo.addColumn("Especie");

//        modelo.addColumn("Paises");
        Object[] fila = new Object[1];
        for (int i = 0; i < lista.size(); i++) {
            fila = lista.get(i).arreglo();
            modelo.addRow(fila);
        }
    }

    public void limpiarTabla() {
        int filas = modelo.getRowCount();
        System.out.println(modelo.getRowCount());
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    

    public void mostrarPreguntas(ArrayList<Preguntas> preguntasFacil, ArrayList<Preguntas> preguntasNormal, ArrayList<Preguntas> preguntasDificil, String dificultad) {
        if (dificultad == "Facil") {
            QuizForm.pregunta1Txt.setText(preguntasFacil.get(0).getPregunta());
            QuizForm.pregunta2Txt.setText(preguntasFacil.get(1).getPregunta());
            QuizForm.pregunta3Txt.setText(preguntasFacil.get(2).getPregunta());
            QuizForm.pregunta4Txt.setText(preguntasNormal.get(0).getPregunta());
            QuizForm.pregunta5Txt.setText(preguntasNormal.get(1).getPregunta());
        } else if (dificultad == "Normal") {
            QuizForm.pregunta1Txt.setText(preguntasNormal.get(0).getPregunta());
            QuizForm.pregunta2Txt.setText(preguntasNormal.get(1).getPregunta());
            QuizForm.pregunta3Txt.setText(preguntasNormal.get(2).getPregunta());
            QuizForm.pregunta4Txt.setText(preguntasDificil.get(0).getPregunta());
            QuizForm.pregunta5Txt.setText(preguntasDificil.get(1).getPregunta());
        } else if (dificultad == "Dificil") {
            QuizForm.pregunta1Txt.setText(preguntasDificil.get(0).getPregunta());
            QuizForm.pregunta2Txt.setText(preguntasDificil.get(1).getPregunta());
            QuizForm.pregunta3Txt.setText(preguntasDificil.get(2).getPregunta());
            QuizForm.pregunta4Txt.setText(preguntasDificil.get(3).getPregunta());
            QuizForm.pregunta5Txt.setText(preguntasDificil.get(4).getPregunta());
        } else if (dificultad == "Mixta") {
            QuizForm.pregunta1Txt.setText(preguntasDificil.get(0).getPregunta());
            QuizForm.pregunta2Txt.setText(preguntasDificil.get(4).getPregunta());
            QuizForm.pregunta3Txt.setText(preguntasDificil.get(1).getPregunta());
            QuizForm.pregunta4Txt.setText(preguntasNormal.get(2).getPregunta());
            QuizForm.pregunta5Txt.setText(preguntasFacil.get(1).getPregunta());
        }
    }
    
    public Boolean validarCampos(){
        String error = "Campo vacio";
        if(this.QuizForm.respuestaTxt.getText().equals("")){
            this.QuizForm.mensaje1Txt.setText(error);
            return false;
        }
        
        if(this.QuizForm.respuesta1Txt.getText().equals("")){
            this.QuizForm.mensaje2Txt.setText(error);
            return false;
        }
        
        if(this.QuizForm.respuesta2Txt.getText().equals("")){
            this.QuizForm.mensaje3Txt.setText(error);
            return false;
        }
        
        if(this.QuizForm.respuesta3Txt.getText().equals("")){
            this.QuizForm.mensaje4Txt.setText(error);
            return false;
        }
        
        if(this.QuizForm.respuesta4Txt.getText().equals("")){
            this.QuizForm.mensaje5Txt.setText(error);
            return false;
        }
        
        
        return true;
    }
    
    public void limpiarErrores(){
        this.QuizForm.mensaje1Txt.setText("");
        this.QuizForm.mensaje2Txt.setText("");
        this.QuizForm.mensaje3Txt.setText("");
        this.QuizForm.mensaje4Txt.setText("");
        this.QuizForm.mensaje5Txt.setText("");
    }

    public void calificar(String res, String res1, String res2, String res3, String res4) {
        String respuestas[];
        respuestas = new String[5];
        int oldP = 0;
        Boolean valida = this.validarCampos();
        
        if(!valida){
            return;
        }
        respuestas[0] = res;
        respuestas[1] = res1;
        respuestas[2] = res2;
        respuestas[3] = res3;
        respuestas[4] = res4;

        ConsultasTaxonomia modT = new ConsultasTaxonomia();
        Taxonomia mod = new Taxonomia();
        mod.setEspecie(this.QuizForm.nombreEspecieLbl.getText());
        modT.buscar(mod);
        
        Preguntas p = new Preguntas();
        ConsultasUsuario con = new ConsultasUsuario();
        for (int i = 0; i < 5; i++) {
           
            if(respuestas[i].equals(mod.getReino())){
                oldP +=2;
            } else if(respuestas[i].equals(mod.getGenero())){
                oldP += 2;
            } else if(respuestas[i].equals(mod.getAlimentacion())){
                oldP += 2;
            } else if(respuestas[i].equals(mod.getFamilia())){
                oldP +=4;
            } else if(respuestas[i].equals(mod.getDominio())){
                 oldP +=4;
            } else if(respuestas[i].equals(mod.getClase())){
                 oldP +=4;
            } else if(respuestas[i].equals(mod.getOrden())){
                oldP +=6;
            } else if(respuestas[i].equals(mod.getFilo())){
                oldP += 6;
            } else if(respuestas[i].equals(String.valueOf(mod.getPeso()))){
                oldP += 6;
            }
        }
       
        usuario = usuarioModelo.PuntajeAnterior(MenuCtrl.getNickname());
        oldP += usuario.getPuntaje();
        con.puntajeNuevo(oldP, usuario.getNickname());
    }

}
