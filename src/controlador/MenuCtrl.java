package controlador;

import view.usuario.UsuarioLogin;
import dinobase.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;

public class MenuCtrl implements ActionListener{
    private UsuarioLogin login;
    private static Usuario user;
    private RegistroVisitanteCtrl visit;
    
    
    public MenuCtrl(){
        login = new UsuarioLogin();

        this.login.registrarseBtn.addActionListener(this);
        this.login.taxBtn.addActionListener(this);
        this.login.paisBtn.addActionListener(this);
        this.login.tiempoBtn.addActionListener(this);
        this.login.climaBtn.addActionListener(this);
        this.login.paleanBtn.addActionListener(this);
        
        
        login.setLocationRelativeTo(null);
        
    }
    
    public static String getNickname(){
        return user.getNickname();
    }
    
    public void iniciar(){
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.bloquear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login.loguearseBtn){
            ConsultasUsuario consulta = new ConsultasUsuario();
            String nickname = login.nicknameTF.getText();
            String pass = login.pass.getText();
            user = consulta.validarUsuario(nickname, pass);
            if(user==null)
                return;
            if("Administrador".equals(user.getTipoU())){
                System.out.println("pasaLogin");
               desbloquear(user.getNickname());
            }else if("Visitante".equals(user.getTipoU())){
               this.login.setVisible(false);
               visit = new RegistroVisitanteCtrl();
               visit.iniciar();
            }
        } else 
        
        if(e.getSource()==login.registrarseBtn){
            UsuarioCtrl ctrlU = new UsuarioCtrl(new Usuario(), new ConsultasUsuario());
            ctrlU.iniciar();
            this.login.setVisible(false);
        } else 
            
        if(e.getSource()==login.taxBtn){
            TaxonomiaCtrl ctrlTax = new TaxonomiaCtrl(new Taxonomia(), new ConsultasTaxonomia());
            ctrlTax.iniciar();
            login.setVisible(false);
        } else 
        
        if(e.getSource()==login.paleanBtn){
            PaleontologoCtrl ctrlP = new PaleontologoCtrl(new Paleontologo(), new ConsultasPaleontologo());
            ctrlP.iniciar();
            login.setVisible(false);
        }else 
        
        if(e.getSource()== login.tiempoBtn){
            TiempoCtrl ctrlT = new TiempoCtrl(new Tiempo(), new ConsultasTiempo());
            ctrlT.iniciar();
            login.setVisible(false);
        }
        
        if(e.getSource()== login.paisBtn){
            PaisCtrl ctrlT = new PaisCtrl(new Pais(), new ConsultasPais());
            ctrlT.iniciar();
            login.setVisible(false);
        }
        if(e.getSource()== login.climaBtn){
        ClimaCtrl ctrlT = new ClimaCtrl(new Clima(), new ConsultasClima());
        ctrlT.iniciar();
        login.setVisible(false);
        }
    }
    
    public void bloquear(){
        this.login.loguearseBtn.addActionListener(this);
        this.login.registrarseBtn.addActionListener(this);
        this.login.taxonomiasLbl.setVisible(false);
        this.login.paisesLbl.setVisible(false);
        this.login.periodosLbl.setVisible(false);
        this.login.climasLbl.setVisible(false);
        this.login.paleontologosLbl.setVisible(false);
        
        this.login.nameTaxLbl.setVisible(false);
        this.login.namePaisLbl.setVisible(false);
        this.login.namePeriodosLbl.setVisible(false);
        this.login.namePaleaLbl.setVisible(false);
        this.login.nameClimasLbl.setVisible(false);
        
        this.login.taxBtn.setVisible(false);
        this.login.paisBtn.setVisible(false);
        this.login.tiempoBtn.setVisible(false);
        this.login.climaBtn.setVisible(false);
        this.login.paleanBtn.setVisible(false);
        
        this.login.BienvenidoLbl.setVisible(false);
        this.login.userLbl.setVisible(false);
    }
    
    public void desbloquear(String user){
        this.login.nameNickNameLbl.setVisible(false);
        this.login.namePassLbl.setVisible(false);
        this.login.nicknameTF.setVisible(false);
        this.login.pass.setVisible(false);
        this.login.loguearseBtn.setVisible(false);
        this.login.registrarseBtn.setVisible(false);
        this.login.jSeparator3.setVisible(false);
        this.login.jSeparator4.setVisible(false);
        
        this.login.BienvenidoLbl.setVisible(true);
        this.login.userLbl.setVisible(true);
        this.login.userLbl.setText(user);
        
        this.login.taxonomiasLbl.setVisible(true);
        this.login.paisesLbl.setVisible(true);
        this.login.periodosLbl.setVisible(true);
        this.login.climasLbl.setVisible(true);
        this.login.paleontologosLbl.setVisible(true);
        
        this.login.nameTaxLbl.setVisible(true);
        this.login.namePaisLbl.setVisible(true);
        this.login.namePeriodosLbl.setVisible(true);
        this.login.namePaleaLbl.setVisible(true);
        this.login.nameClimasLbl.setVisible(true);
        
        this.login.taxBtn.setVisible(true);
        this.login.paisBtn.setVisible(true);
        this.login.tiempoBtn.setVisible(true);
        this.login.climaBtn.setVisible(true);
        this.login.paleanBtn.setVisible(true);
    }

   
}
