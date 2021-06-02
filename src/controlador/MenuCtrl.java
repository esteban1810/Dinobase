package controlador;

import clase.Tiempo;
import clase.Taxonomia;
import clase.Pais;
import clase.Usuario;
import view.usuario.UsuarioLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;

public final class MenuCtrl implements ActionListener{
    private final UsuarioLogin frameLogin;
    private static Usuario user;
    private quizCtrl juego;
    private EstadisticasCtrl estadisticas;
    private DiccionarioCtrl visit;
    
    
    public MenuCtrl(){
        //Instacia del frame UsuarioLogin
        frameLogin = new UsuarioLogin();

        vincularBotones();
        
        //Centrar Frame de login
        frameLogin.setLocationRelativeTo(null);
        
    }
    
    public void vincularBotones(){
        this.frameLogin.registrarseBtn.addActionListener(this);
        this.frameLogin.taxBtn.addActionListener(this);
        this.frameLogin.paisBtn.addActionListener(this);
        this.frameLogin.tiempoBtn.addActionListener(this);
        this.frameLogin.climaBtn.addActionListener(this);
        this.frameLogin.paleanBtn.addActionListener(this);
        this.frameLogin.cerrarSesionBtn.addActionListener(this);
        this.frameLogin.jugarBtn.addActionListener(this);
        this.frameLogin.estadisticasBtn.addActionListener(this);
    }
    
    public static String getNickname(){
        return user.getNickname();
    }
    
    public void iniciar(){
        frameLogin.setVisible(true); // muestra el frame
        frameLogin.setLocationRelativeTo(null); //centra el frame
        this.bloquear();
        this.bloquearAdmin();
        this.bloquearVisitante();
    }
    
    public void loguearse(){
        ConsultasUsuario consulta = new ConsultasUsuario();
        String nickname = frameLogin.nicknameTF.getText();
        String pass = frameLogin.pass.getText();
        user = consulta.validarUsuario(nickname, pass);
        if(user==null){
            return;
        }
        if("Administrador".equals(user.getTipoU())){
            desbloquear(user.getNickname());
            frameLogin.panelVisitante.setVisible(false);
            frameLogin.panelAdmin.setVisible(true);

        }else if("Visitante".equals(user.getTipoU())){
            desbloquear(user.getNickname());
            frameLogin.panelAdmin.setVisible(false);
            frameLogin.panelVisitante.setVisible(true);
        }
    }
    
    public void administrador(){
        frameLogin.panelAdmin.setVisible(true);
        frameLogin.panelVisitante.setVisible(false);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==frameLogin.loguearseBtn){
            loguearse();
        } else 
            
        if(e.getSource()==frameLogin.registrarseBtn){
            UsuarioCtrl ctrlU = new UsuarioCtrl(new Usuario(), new ConsultasUsuario());
            ctrlU.iniciar();
            this.frameLogin.setVisible(false);
        } else 
            
        if(e.getSource()==frameLogin.taxBtn){
            TaxonomiaCtrl ctrlTax = new TaxonomiaCtrl();
            ctrlTax.iniciar();
            frameLogin.setVisible(false);
        } else 
        
        if(e.getSource()==frameLogin.paleanBtn){
            PaleontologoCtrl ctrlP = new PaleontologoCtrl();
            ctrlP.iniciar();
            ctrlP.likeVisita();
            frameLogin.setVisible(false);
        }else 
        
        if(e.getSource()== frameLogin.tiempoBtn){
            TiempoCtrl ctrlT = new TiempoCtrl();
            ctrlT.iniciar();
            ctrlT.likeVisita();
            frameLogin.setVisible(false);
        } else
        
        if(e.getSource()== frameLogin.paisBtn){
            PaisCtrl ctrlT = new PaisCtrl();
            ctrlT.iniciar();
            ctrlT.likeVisita();
            frameLogin.setVisible(false);
        } else 
        
        if(e.getSource()== frameLogin.climaBtn){
            ClimaCtrl ctrlT = new ClimaCtrl();
            ctrlT.iniciar();
            ctrlT.likeVisita();
            frameLogin.setVisible(false);
        } else 
        
        if(e.getSource()==frameLogin.consultarBtn){
            this.frameLogin.setVisible(false);
            visit = new DiccionarioCtrl();
            visit.iniciar();
        }  else if(e.getSource()==frameLogin.jugarBtn){
            this.frameLogin.setVisible(false);
            juego = new quizCtrl();
            juego.iniciar();
        }  else if(e.getSource()==frameLogin.estadisticasBtn){
            this.frameLogin.setVisible(false);
            estadisticas = new EstadisticasCtrl();
            estadisticas.iniciar();
        }  else if(e.getSource()==frameLogin.cerrarSesionBtn){
            
            this.bloquear();
            this.inicioSesion();
            this.bloquearAdmin();
            this.bloquearVisitante();
        }
    }
    
    public void bloquearVisitante(){
        frameLogin.panelVisitante.setVisible(false);
    }
    
    public void bloquearAdmin(){
        frameLogin.panelAdmin.setVisible(false);
    }
    
    public void desbloquearVisitante(){
        frameLogin.panelVisitante.setVisible(true);
    }
    
    public void desbloquearAdmin(){
        frameLogin.panelAdmin.setVisible(true);
    }
    
    public void bloquear(){
        this.frameLogin.loguearseBtn.addActionListener(this);
        this.frameLogin.registrarseBtn.addActionListener(this);
        this.frameLogin.consultarBtn.addActionListener(this);
        
        this.frameLogin.BienvenidoLbl.setVisible(false);
        this.frameLogin.userLbl.setVisible(false);
        this.frameLogin.cerrarSesionBtn.setVisible(false);
    }
    
    public void desbloquear(String user){
        this.frameLogin.nameNickNameLbl.setVisible(false);
        this.frameLogin.namePassLbl.setVisible(false);
        this.frameLogin.nicknameTF.setVisible(false);
        this.frameLogin.pass.setVisible(false);
        this.frameLogin.loguearseBtn.setVisible(false);
        this.frameLogin.registrarseBtn.setVisible(false);
        this.frameLogin.jSeparator3.setVisible(false);
        this.frameLogin.jSeparator4.setVisible(false);
        
        this.frameLogin.BienvenidoLbl.setVisible(true);
        this.frameLogin.userLbl.setVisible(true);
        this.frameLogin.userLbl.setText(user);
        this.frameLogin.cerrarSesionBtn.setVisible(true);
    }
    
    public void inicioSesion(){
        this.frameLogin.nameNickNameLbl.setVisible(true);
        this.frameLogin.namePassLbl.setVisible(true);
        this.frameLogin.nicknameTF.setVisible(true);
        this.frameLogin.pass.setVisible(true);
        this.frameLogin.loguearseBtn.setVisible(true);
        this.frameLogin.registrarseBtn.setVisible(true);
        this.frameLogin.jSeparator3.setVisible(true);
        this.frameLogin.jSeparator4.setVisible(true);
    }
}
