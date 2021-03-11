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
    private RegistroVisitanteCtrl visit;
    
    
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
    }
    
    public static String getNickname(){
        return user.getNickname();
    }
    
    public void iniciar(){
        frameLogin.setVisible(true); // muestra el frame
        frameLogin.setLocationRelativeTo(null); //centra el frame
        this.bloquear();
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
        }else if("Visitante".equals(user.getTipoU())){
           this.frameLogin.setVisible(false);
           visit = new RegistroVisitanteCtrl();
           visit.iniciar();
        }
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
            TaxonomiaCtrl ctrlTax = new TaxonomiaCtrl(new Taxonomia(), new ConsultasTaxonomia());
            ctrlTax.iniciar();
            frameLogin.setVisible(false);
        } else 
        
        if(e.getSource()==frameLogin.paleanBtn){
            PaleontologoCtrl ctrlP = new PaleontologoCtrl();
            ctrlP.iniciar();
            frameLogin.setVisible(false);
        }else 
        
        if(e.getSource()== frameLogin.tiempoBtn){
            TiempoCtrl ctrlT = new TiempoCtrl(new Tiempo(), 
                    new ConsultasTiempo());
            ctrlT.iniciar();
            frameLogin.setVisible(false);
        }
        
        if(e.getSource()== frameLogin.paisBtn){
            PaisCtrl ctrlT = new PaisCtrl();
            ctrlT.iniciar();
            frameLogin.setVisible(false);
        }
        
        if(e.getSource()== frameLogin.climaBtn){
//            ClimaCtrl ctrlT = new ClimaCtrl(new Clima(), new ConsultasClima());
            ClimaCtrl ctrlT = new ClimaCtrl();
            ctrlT.iniciar();
            frameLogin.setVisible(false);
        }
    }
    
    public void bloquear(){
        this.frameLogin.loguearseBtn.addActionListener(this);
        this.frameLogin.registrarseBtn.addActionListener(this);
        this.frameLogin.taxonomiasLbl.setVisible(false);
        this.frameLogin.paisesLbl.setVisible(false);
        this.frameLogin.periodosLbl.setVisible(false);
        this.frameLogin.climasLbl.setVisible(false);
        this.frameLogin.paleontologosLbl.setVisible(false);
        
        this.frameLogin.nameTaxLbl.setVisible(false);
        this.frameLogin.namePaisLbl.setVisible(false);
        this.frameLogin.namePeriodosLbl.setVisible(false);
        this.frameLogin.namePaleaLbl.setVisible(false);
        this.frameLogin.nameClimasLbl.setVisible(false);
        
        this.frameLogin.taxBtn.setVisible(false);
        this.frameLogin.paisBtn.setVisible(false);
        this.frameLogin.tiempoBtn.setVisible(false);
        this.frameLogin.climaBtn.setVisible(false);
        this.frameLogin.paleanBtn.setVisible(false);
        
        this.frameLogin.BienvenidoLbl.setVisible(false);
        this.frameLogin.userLbl.setVisible(false);
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
        
        this.frameLogin.taxonomiasLbl.setVisible(true);
        this.frameLogin.paisesLbl.setVisible(true);
        this.frameLogin.periodosLbl.setVisible(true);
        this.frameLogin.climasLbl.setVisible(true);
        this.frameLogin.paleontologosLbl.setVisible(true);
        
        this.frameLogin.nameTaxLbl.setVisible(true);
        this.frameLogin.namePaisLbl.setVisible(true);
        this.frameLogin.namePeriodosLbl.setVisible(true);
        this.frameLogin.namePaleaLbl.setVisible(true);
        this.frameLogin.nameClimasLbl.setVisible(true);
        
        this.frameLogin.taxBtn.setVisible(true);
        this.frameLogin.paisBtn.setVisible(true);
        this.frameLogin.tiempoBtn.setVisible(true);
        this.frameLogin.climaBtn.setVisible(true);
        this.frameLogin.paleanBtn.setVisible(true);
    }
}
