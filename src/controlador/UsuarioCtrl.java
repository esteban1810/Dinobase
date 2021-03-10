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
    
    public UsuarioCtrl(Usuario mod, ConsultasUsuario modC){
        this.mod=mod;
        this.modC=modC;
        this.frame=new UsuarioForm();
        
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
            mod.setFechaN(new Date(frame.fechaN.getDate().getTime()));
            
            if(frame.visitanteRB.isSelected()){
                mod.setTipoU("Visitante");
            } else {
                mod.setTipoU("Administrador");
            }
            
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
