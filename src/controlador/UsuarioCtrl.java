package controlador;

import clase.Usuario;
import view.usuario.UsuarioForm;
import view.usuario.UsuarioLogin;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.awt.event.*;
import modelo.*;

public class UsuarioCtrl implements ActionListener {
    private Usuario mod;
    private ConsultasUsuario modC;
    private UsuarioForm frame;
    
    public UsuarioCtrl(UsuarioForm usuarioForm){
        this.mod=new Usuario();
        this.modC=new ConsultasUsuario();
        this.frame=usuarioForm;
        
        this.frame.registrarBtn.addActionListener(this);
        
    }
    
    public void iniciar(){
        frame.setTitle("Registro");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.registrarBtn){
            mod.setNickname(frame.nicknameTF.getText());
            mod.setCorreo(frame.correoTF.getText());
            mod.setPass(frame.passTF.getText());
            try{
                System.out.println(frame.fechaN.getDate());
                System.out.println("pasa");
                mod.setFechaN(new Date(frame.fechaN.getDate().getTime()));
            }catch(Exception ex){
                System.out.println("aqui ando");
            }
            
            if(frame.visitanteRB.isSelected()){
                mod.setTipoU("Visitante");
            } else {
                mod.setTipoU("Administrador");
            }
            
            System.out.println(mod);
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
        }
    }
    
    public void limpiar(){
        frame.nicknameTF.setText(null);
        frame.correoTF.setText(null);
        frame.pass2TF.setText(null);
        frame.passTF.setText(null);
        frame.fechaN.setDate(null);
        frame.visitanteRB.setSelected(false);
        frame.administradorRB.setSelected(false);
        frame.tipoUserGB.clearSelection();
    }
    
    public Usuario getUsuario(){
        return mod;
    }
}
