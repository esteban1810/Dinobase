package controlador;

import framesUsuario.UsuarioFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.Usuario;

public class UsuarioCtrl implements ActionListener {
    private Usuario mod;
    private ConsultasUsuario modC;
    private UsuarioFrame frame;
    
    public UsuarioCtrl(Usuario mod, ConsultasUsuario modC, UsuarioFrame frame){
        this.mod=mod;
        this.modC=modC;
        this.frame=frame;
        this.frame.registrarBtn.addActionListener(this);
        this.frame.buscarBtn.addActionListener(this);
        this.frame.eliminarBtn.addActionListener(this);
        this.frame.limpiarBtn.addActionListener(this);
        this.frame.modificarBtn.addActionListener(this);
    }
    
    public void iniciar(){
        frame.setTitle("Usuarios");
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
        
        if(e.getSource() == frame.modificarBtn){
            mod.setNickname(frame.nicknameTF.getText());
            mod.setCorreo(frame.correoTF.getText());
            mod.setPass(frame.passTF.getText());
            mod.setFechaN(new Date(frame.fechaN.getDate().getTime()));
            if(frame.visitanteRB.isSelected()){
                mod.setTipoU("Visitante");
            } else {
                mod.setTipoU("Administrador");
            }
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            limpiar();
        }
        
        if(e.getSource() == frame.eliminarBtn){
            mod.setNickname(frame.nicknameTF.getText());
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            limpiar();
        }
        
        if(e.getSource() == frame.buscarBtn){
            mod.setNickname(frame.nicknameTF.getText());
            
            if(modC.buscar(mod)){
                frame.nicknameTF.setText(mod.getNickname());
                frame.correoTF.setText(mod.getCorreo());
                frame.passTF.setText(mod.getPass());
                frame.pass2TF.setText(mod.getPass());
                frame.fechaN.setDate(mod.getFechaN());
                
                if(mod.getTipoU().equalsIgnoreCase("Visitante")){
                    frame.visitanteRB.setSelected(true);
                } else {
                    frame.administradorRB.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
        }
        
        if(e.getSource()==frame.limpiarBtn){
            limpiar();
        }
    }
    
    public void limpiar(){
        frame.nicknameTF.setText(null);
        frame.correoTF.setText(null);
        frame.pass2TF.setText(null);
        frame.passTF.setText(null);
        frame.fechaN.setDate(null);
//        frame.edadTF.setText(null);
        frame.visitanteRB.setSelected(false);
        frame.administradorRB.setSelected(false);
        frame.tipoUserGB.clearSelection();
    }
}
